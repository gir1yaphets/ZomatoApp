package com.example.zomatoapp;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ZomatoApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        initializeRealm();
    }

    private void initializeRealm() {
        //Initialize the Realm
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder().name("zomato.realm").build();
        Realm.setDefaultConfiguration(config);
    }

    public static Context getContext() {
        return context;
    }
}
