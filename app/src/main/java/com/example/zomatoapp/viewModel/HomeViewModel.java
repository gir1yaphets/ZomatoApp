package com.example.zomatoapp.viewModel;

import android.util.Log;
import android.view.View;

import com.example.zomatoapp.dataModel.CategoryListModel;
import com.example.zomatoapp.network.ApiService;
import com.example.zomatoapp.network.RetrofitApiCallback;
import com.example.zomatoapp.network.RetrofitErrorModel;

import retrofit2.Response;

public class HomeViewModel {
    private static final String TAG = "HomeViewModel";

    public void onTextClick(View view) {
        ApiService.getInstance().retrieveCategoryList(new RetrofitApiCallback<CategoryListModel>(new RetrofitApiCallback.OnActionHandleListener() {
            @Override
            public void onBeforeHandling() {

            }

            @Override
            public void onSuccess(Response response) {
                Log.d(TAG, "onSuccess: result = " + response.code());
            }

            @Override
            public void onError(RetrofitErrorModel errors) {

            }

            @Override
            public void onTechIssueError(Throwable t) {

            }

            @Override
            public void onSpecialHandleError(Response response) {

            }
        }));
    }
}
