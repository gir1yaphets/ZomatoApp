package com.example.zomatoapp.viewModel;

import android.content.Context;
import android.location.Location;

import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.helper.ZomatoDataHelper;

import androidx.databinding.ObservableField;

public class CommonViewModel {
    private Context context;
    private ZomatoDataHelper zomatoDataHelper;

    public CommonViewModel(Context context) {
        this.context = context;
        zomatoDataHelper = new ZomatoDataHelper(context);
    }

    public ObservableField<String> cityName = new ObservableField<>();

    public void retrieveRestaurantInfo(int id) {
        zomatoDataHelper.retrieveRestaurant(id);
    }

    public void getCityInfo(int categoryId) {
        zomatoDataHelper.getCityInfo(categoryId, LocationHelper.getInstance().getCurrentLocation());
    }

    public void getSearchResult(int cityId, int collectionId, int categoryId, Location location) {
        zomatoDataHelper.getSearchResult(cityId, collectionId, categoryId, location);
    }

    public void retrieveCollections(int cityId) {
        zomatoDataHelper.retrieveCollection(cityId);
    }
}