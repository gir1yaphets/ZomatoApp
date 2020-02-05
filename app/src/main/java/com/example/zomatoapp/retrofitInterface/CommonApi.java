package com.example.zomatoapp.retrofitInterface;

import com.example.zomatoapp.dataModel.CategoryListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CommonApi {

    @GET("{apiVersion}/categories")
    Call<CategoryListModel> getCategories(
            @Path("apiVersion") String apiVersion,
            @Header("user-key") String apiKey
    );
}
