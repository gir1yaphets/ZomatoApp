package com.example.zomatoapp.retrofitInterface;

import com.example.zomatoapp.dataModel.CategoryListModel;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantApi {

    @GET("{apiVersion}/restaurant")
    Call<RestaurantModel> getRestaurant(
            @Path("apiVersion") String apiVersion,
            @Query("res_id") int restaurantId
    );


}
