package com.example.zomatoapp.dataModel.requestModel;

import android.location.Location;

public class SearchRequestModel extends RequestDataModel {
    public SearchRequestModel(String actionType) {
        super(actionType);
    }

    private int categoryId;

    private int cityId;

    private int collectionId;

    private Location location;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
