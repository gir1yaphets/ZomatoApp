package com.example.zomatoapp.dataModel.requestModel;

public class CollectionRequestModel extends RequestDataModel {
    public CollectionRequestModel(String actionType) {
        super(actionType);
    }

    private int cityId;

    private int categoryId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
