package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DbSearchModel extends RealmObject {
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

    @PrimaryKey
    private String id;

    private RealmList<DbRestaurantsModel> restaurants;
}
