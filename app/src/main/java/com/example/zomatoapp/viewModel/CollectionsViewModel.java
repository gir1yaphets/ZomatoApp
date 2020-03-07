package com.example.zomatoapp.viewModel;

import android.content.Context;
import android.location.Location;

import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.helper.ZomatoDataHelper;

public class CollectionsViewModel {
    private Context context;
    private ZomatoDataHelper zomatoDataHelper;

    public CollectionsViewModel(Context context) {
        this.context = context;
        zomatoDataHelper = new ZomatoDataHelper(context);
    }

    public void getCityInfo() {
        zomatoDataHelper.getCityInfo(LocationHelper.getInstance().getCurrentLocation());
    }
    public void retrieveCollections(int cityId) {
        zomatoDataHelper.retrieveCollection(cityId);
    }

    public void getSearchResult(int cityId, int collectionId, Location location) {
        zomatoDataHelper.getSearchResult(cityId, collectionId, location);
    }


}
