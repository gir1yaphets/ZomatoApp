package com.example.zomatoapp.viewModel;

import android.content.Context;
import android.view.View;

import com.example.zomatoapp.helper.ZomatoDataHelper;

public class HomeViewModel {
    private static final String TAG = "HomeViewModel";

    private ZomatoDataHelper zomatoDataHelper;

    public HomeViewModel(Context context) {
        zomatoDataHelper = new ZomatoDataHelper(context);
    }

    public void onTextClick(View view) {
        zomatoDataHelper.retrieveRestaurant();
    }
}
