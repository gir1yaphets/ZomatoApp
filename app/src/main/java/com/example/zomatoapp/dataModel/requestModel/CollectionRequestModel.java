package com.example.zomatoapp.dataModel.requestModel;

public class CollectionRequestModel extends RequestDataModel {
    public CollectionRequestModel(String actionType) {
        super(actionType);
    }

    private int cityId;

    private int categoryId;

    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
