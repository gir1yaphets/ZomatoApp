package com.example.zomatoapp.viewModel;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.view.View;
import android.widget.Toast;

import com.example.zomatoapp.activities.RestaurantActivity;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.helper.ZomatoDataHelper;

import androidx.databinding.ObservableField;

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
