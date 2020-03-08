package com.example.zomatoapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.zomatoapp.helper.SharePreHelper;

public class CommonUtil {
    private static final String TAG = CommonUtil.class.getSimpleName();

    public static String getCompoundKey(Context context, int cityId, int category) {
        String uuid = SharePreHelper.getString(context, StaticValues.SHARE_PRE_KEY_UUID);
        return uuid + "-" + cityId + "-" + category;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) return false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (info == null) {
            return false;
        }

        return info.isAvailable();
    }

    public static long getCurrTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }
}
