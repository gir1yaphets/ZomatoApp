package com.example.zomatoapp.network;

import com.example.zomatoapp.dataModel.CategoryListModel;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.retrofitInterface.CommonApi;
import com.example.zomatoapp.retrofitInterface.RestaurantApi;
import com.example.zomatoapp.utils.StaticValues;

import java.util.Map;

import retrofit2.Call;

public class ApiService {
    private static ApiService instance;

    private ApiService() {
    }

    public static ApiService getInstance() {
        if (instance == null) {
            synchronized (ApiService.class) {
                if (instance == null) {
                    instance = new ApiService();
                }
            }
        }

        return instance;
    }

    public void retrieveCategoryList(RetrofitApiCallback<CategoryListModel> callback) {
        Call commonCall = HttpUtils.getApiGatewayRetrofit().create(CommonApi.class).getCategories(StaticValues.API_VERSION);

        commonCall.enqueue(callback);
    }

    public void retrieveCollections(RetrofitApiCallback<CollectionListModel> callback) {
        Call commonCall = HttpUtils.getApiGatewayRetrofit().create(CommonApi.class).getCollections(
                StaticValues.API_VERSION,
                280,
                40.732013,
                -73.996155,
                5
        );

        commonCall.enqueue(callback);
    }

    public void retrieveRestaurant(RetrofitApiCallback<RestaurantModel> callback) {
        Call restaurantCall = HttpUtils.getApiGatewayRetrofit().create(RestaurantApi.class).getRestaurant(
                StaticValues.API_VERSION,
                16774318
        );

        restaurantCall.enqueue(callback);
    }

    public void retrieveSearchResult(RetrofitApiCallback<RestaurantModel> callback, Map<String, Object> params) {
        Call restaurantCall = HttpUtils.getApiGatewayRetrofit().create(RestaurantApi.class).getSearchResult(
                StaticValues.API_VERSION,
                params
        );

        restaurantCall.enqueue(callback);
    }
}
