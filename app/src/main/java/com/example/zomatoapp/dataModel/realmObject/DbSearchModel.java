package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmList;
import io.realm.RealmObject;

public class DbSearchModel extends RealmObject {
    public RealmList<DbRestaurantModel> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(RealmList<DbRestaurantModel> restaurants) {
        this.restaurants = restaurants;
    }

    private RealmList<DbRestaurantModel> restaurants;
}
