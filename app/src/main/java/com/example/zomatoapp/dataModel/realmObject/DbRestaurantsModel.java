package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmObject;

public class DbRestaurantsModel extends RealmObject {
    public DbRestaurantModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(DbRestaurantModel restaurant) {
        this.restaurant = restaurant;
    }

    private DbRestaurantModel restaurant;
}
