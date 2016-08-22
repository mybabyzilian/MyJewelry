package com.example.admin.jewelry.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2016/8/16.
 */
public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
