package com.example.zomatoapp.network;

import com.example.zomatoapp.dataModel.CategoryListModel;
import com.example.zomatoapp.retrofitInterface.CommonApi;
import com.example.zomatoapp.utils.StaticValues;

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
        Call commonCall = HttpUtils.getApiGatewayRetrofit().create(CommonApi.class).getCategories(
                StaticValues.API_VERSION,
                StaticValues.USER_KEY);

        commonCall.enqueue(callback);
    }
}
