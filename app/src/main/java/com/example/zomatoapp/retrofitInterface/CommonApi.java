package com.example.zomatoapp.retrofitInterface;

import com.example.zomatoapp.dataModel.AllReviewsModel;
import com.example.zomatoapp.dataModel.CategoryListModel;
import com.example.zomatoapp.dataModel.CityModel;
import com.example.zomatoapp.dataModel.CollectionListModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface CommonApi {

    @GET("{apiVersion}/categories")
    Call<CategoryListModel> getCategories(
            @Path("apiVersion") String apiVersion
    );

    @GET("{apiVersion}/collections")
    Call<CollectionListModel> getCollections(
            @Path("apiVersion") String apiVersion,
            @Query("city_id") int cityId,
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("count") int count
    );

    @GET("{apiVersion}/cities")
    Call<CityModel> getCities(
            @Path("apiVersion") String apiVersion,
            @QueryMap Map<String, Object> params
    );

    @GET("{apiVersion}/reviews")
    Call<AllReviewsModel> getReviews(
            @Path("apiVersion") String apiVersion,
            @Query("res_id") int resId,
            @Query("start") int start,
            @Query("end") int end
    );
}
