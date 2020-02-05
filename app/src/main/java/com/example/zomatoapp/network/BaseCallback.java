package com.example.zomatoapp.network;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class BaseCallback<T> implements Callback<T> {

    private static final String TAG = BaseCallback.class.getName();
    
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d(TAG, "onResponse: ");
        onServiceResponse(call, response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d(TAG, "onFailure: ");
    }

    protected abstract void onServiceResponse(Call<T> call, Response<T> response);
}
