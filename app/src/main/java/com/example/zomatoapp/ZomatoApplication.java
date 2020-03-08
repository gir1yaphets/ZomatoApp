package com.example.zomatoapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import androidx.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ZomatoApplication extends Application {
    private static final String TAG = ZomatoApplication.class.getName();
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
        initializeCloudMessaging();
    }

    private void initializeCloudMessaging() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        Log.d(TAG, "token = " + token);
                    }
                });
    }

    public static Context getContext() {
        return context;
    }
}
