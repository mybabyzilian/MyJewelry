package com.example.admin.jewelry.certificate;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.Utils.CharacterParser;
import com.example.admin.jewelry.Utils.ClearEditText;
import com.example.admin.jewelry.Utils.PinyinComparator;
import com.example.admin.jewelry.Utils.SideBar;
import com.example.admin.jewelry.encyclopedia_fragment.EncyListBean;
import com.example.admin.jewelry.encyclopedia_fragment.EncyAdapter;
import com.example.admin.jewelry.netrequest.OkHttpClientManager;
import com.example.admin.jewelry.netrequest.Urls;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CertificateActivity extends Activity {
	private ListView sortListView;
	private SideBar sideBar;
	private TextView dialog;
	private EncyAdapter adapter;
	private ClearEditText mClearEditText;
	private CharacterParser characterParser;
	private List<EncyListBean> SourceDateList;
	private CertificateBean bean;
	private PinyinComparator pinyinComparator;
	private List<CertificateBean.ObjectBean.DetailBean> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_certificate);
		sortListView = (ListView) findViewById(R.id.country_lvcountry);
		sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {

				Toast.makeText(getApplication(), ((EncyListBean)adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
			}
		});
		HashMap<String,String> map = new HashMap<>();
		map.put("id","");
		data = new ArrayList<>();
		characterParser = CharacterParser.getInstance();
		pinyinComparator = new PinyinComparator();
		OkHttpClientManager.postAsyn(Urls.CERTIFICATE_SEARCH, new OkHttpClientManager.ResultCallback<CertificateBean>() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(CertificateBean response) {
				for (int i = 0; i <response.getObject().size() ; i++) {
					data.addAll(response.getObject().get(i).getSAppraisalAgencyinfos());

				}
				SourceDateList = filledData(data);
				Collections.sort(SourceDateList, pinyinComparator);
				adapter = new EncyAdapter(CertificateActivity.this, SourceDateList);
				sortListView.setAdapter(adapter);

			}
		},map);

		sideBar = (SideBar) findViewById(R.id.sidrbar);
		dialog = (TextView) findViewById(R.id.dialog);
		sideBar.setTextView(dialog);
		sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
			@Override
			public void onTouchingLetterChanged(String s) {
				if (data.size() > 0){
					int position = adapter.getPositionForSection(s.charAt(0));
					if (position != -1) {
						sortListView.setSelection(position);
					}
				}
			}
		});



		mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);


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
	 *
	 * @param date
	 * @return
	 */
	private List<EncyListBean> filledData(List<CertificateBean.ObjectBean.DetailBean> date){
		List<EncyListBean> mSortList = new ArrayList<>();

		for(int i=0; i<date.size(); i++){
			EncyListBean sortModel = new EncyListBean();
			sortModel.setName(date.get(i).getAgenct_name());
			String pinyin = characterParser.getSelling(date.get(i).getAgenct_name());
			String sortString = pinyin.substring(0, 1).toUpperCase();


			if(sortString.matches("[A-Z]")){
				sortModel.setSortLetters(sortString.toUpperCase());
			}else{
				sortModel.setSortLetters("#");
			}

			mSortList.add(sortModel);
		}
		return mSortList;
		
	}
	
	/**
	 *
	 * @param filterStr
	 */
	private void filterData(String filterStr){
		List<EncyListBean> filterDateList = new ArrayList<EncyListBean>();
		if (data.size() > 0){
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
