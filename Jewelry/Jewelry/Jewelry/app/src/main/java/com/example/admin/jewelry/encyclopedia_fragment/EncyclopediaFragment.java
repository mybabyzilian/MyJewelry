package com.example.admin.jewelry.encyclopedia_fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;
import com.example.admin.jewelry.netrequest.OkHttpClientManager;
import com.example.admin.jewelry.netrequest.Urls;
import com.example.admin.jewelry.Utils.CharacterParser;
import com.example.admin.jewelry.Utils.ClearEditText;
import com.example.admin.jewelry.Utils.PinyinComparator;
import com.example.admin.jewelry.Utils.SideBar;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/15.
 */
public class EncyclopediaFragment extends BaseFragment {
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private EncyAdapter adapter;
    private ClearEditText mClearEditText;
    private CharacterParser characterParser;
    private List<EncyListBean> SourceDateList;
    private PinyinComparator pinyinComparator;
    private View listHeadView;
    private GridView gridView;
    private EncyGridAdapter gridAdapter;
    private List<EncyBean.ObjectBean.IndexlistBean.EncyDetailBean> data;


    @Override
    protected int setLayout() {

        return R.layout.fragment_ency;

    }

    @Override
    protected void initView(View view) {
        sideBar = (SideBar) view.findViewById(R.id.ency_sidrbar);
        dialog = (TextView) view.findViewById(R.id.ency_dialog);
        listHeadView = LayoutInflater.from(context).inflate(R.layout.ency_list_head, null);
        gridView = (GridView) listHeadView.findViewById(R.id.ency_head_grid);
        sortListView = (ListView) view.findViewById(R.id.ency_list);
        sortListView.addHeaderView(listHeadView);
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        mClearEditText = (ClearEditText) view.findViewById(R.id.filter_edit);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        gridAdapter = new EncyGridAdapter(context);
        Map<String, String> maps = new HashMap<>();
        maps.put("entity_id", "");
        OkHttpClientManager.postAsyn(Urls.ENCY_FIRST_PAGE_URL, new OkHttpClientManager.ResultCallback<EncyBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(EncyBean response) {
                gridAdapter.setData(response);
                gridView.setAdapter(gridAdapter);
                for (int i = 0; i < response.getObject().getIndexlist().size(); i++) {
                    data.addAll(response.getObject().getIndexlist().get(i).getMyVal());
                }
                SourceDateList = filledData(data);
                Collections.sort(SourceDateList, pinyinComparator);
                adapter = new EncyAdapter(context, SourceDateList);
                sortListView.setAdapter(adapter);


            }

        }, maps);
        sideBar.setTextView(dialog);
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                if (data.size() > 0) {
                    int position = adapter.getPositionForSection(s.charAt(0));
                    if (position != -2) {
                        sortListView.setSelection(position);
                    }
                } else {
                    return;
                }
            }
        });
        listHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(context, ((EncyListBean) adapter.getItem(position - 1)).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }


    /**
     * @param date
     * @return
     */
    private List<EncyListBean> filledData(List<EncyBean.ObjectBean.IndexlistBean.EncyDetailBean> date) {
        List<EncyListBean> mSortList = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {

            EncyListBean sortModel = new EncyListBean();
            sortModel.setName(date.get(i).getCategory_name());
            sortModel.setImageUrl(date.get(i).getCategory_pic());
            String pinyin = characterParser.getSelling(date.get(i).getCategory_name());
            String sortString = pinyin.substring(0, 1).toUpperCase();


            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }

        return mSortList;

    }

    /**
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<EncyListBean> filterDateList = new ArrayList<EncyListBean>();
        if (data.size() > 0) {
            if (TextUtils.isEmpty(filterStr)) {
                filterDateList = SourceDateList;
            } else {
                filterDateList.clear();
                for (EncyListBean sortModel : SourceDateList) {
                    String name = sortModel.getName();
                    if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
                        filterDateList.add(sortModel);
                    }
                }
            }
        }else {
            return;
        }

        //
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
    }


}
