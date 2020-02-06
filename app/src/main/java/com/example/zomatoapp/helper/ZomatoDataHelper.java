package com.example.zomatoapp.helper;

import android.content.Context;

import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.network.ApiService;
import com.example.zomatoapp.network.RetrofitApiCallback;
import com.example.zomatoapp.network.RetrofitErrorModel;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Response;

public class ZomatoDataHelper {
    private static final String TAG = ZomatoDataHelper.class.getName();

    private Context mContext;
    private ApiService apiService;

    public ZomatoDataHelper(Context context) {
        mContext = context;
        apiService = ApiService.getInstance();
    }

    public void retrieveCollection() {
        apiService.retrieveCollections(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<CollectionListModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<CollectionListModel> response) {
                        CollectionListModel collectionModelList = response.body();
                        EventBus.getDefault().post(new OnCollectionsSuccessEvent(collectionModelList));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }));
    }

    public void retrieveRestaurant(){
        apiService.retrieveRestaurant(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<RestaurantModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<RestaurantModel> response) {
                        RestaurantModel restaurantModel = response.body();
                        //EventBus.getDefault().post(new OnCollectionsSuccessEvent(restaurantModel));
                        return;
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }));
    }
}
