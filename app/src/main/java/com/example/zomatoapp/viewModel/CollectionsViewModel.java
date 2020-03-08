package com.example.zomatoapp.viewModel;

import android.content.Context;

import com.example.zomatoapp.helper.ZomatoDataHelper;

public class CollectionsViewModel {
    private Context context;
    private ZomatoDataHelper zomatoDataHelper;

    public CollectionsViewModel(Context context) {
        this.context = context;
        zomatoDataHelper = new ZomatoDataHelper(context);
    }

    public void getCityInfo() {
//        zomatoDataHelper.getCityInfo(LocationHelper.getInstance().getCurrentLocation());
    }
}
