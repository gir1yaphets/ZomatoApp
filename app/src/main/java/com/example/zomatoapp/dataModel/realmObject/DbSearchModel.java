package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DbSearchModel extends RealmObject {
    @PrimaryKey
    private String id;

    private int categoryId;

    private RealmList<DbRestaurantsModel> restaurants;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public RealmList<DbRestaurantsModel> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(RealmList<DbRestaurantsModel> restaurants) {
        this.restaurants = restaurants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
