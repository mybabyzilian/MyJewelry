package com.example.admin.jewelry.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RemoteViews;
import android.widget.TextView;

/**
 * Created by admin on 2016/8/16.
 */
@RemoteViews.RemoteView
public class AlwaysMarqueeTextView extends TextView {
    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }
    public AlwaysMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public AlwaysMarqueeTextView(Context context, AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean isFocused() {
        return true;
    }
}
