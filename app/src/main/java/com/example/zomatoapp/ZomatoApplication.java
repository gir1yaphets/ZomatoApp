package com.example.zomatoapp;

import android.app.Application;
import android.content.Context;

public class ZomatoApplication extends Application {
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
