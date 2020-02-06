package com.example.zomatoapp.helper;

import android.content.Context;

import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.network.ApiService;
import com.example.zomatoapp.network.RetrofitApiCallback;
import com.example.zomatoapp.network.RetrofitErrorModel;
import com.example.zomatoapp.utils.StaticValues;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

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
                        EventBus.getDefault().post(new OnRestaurantsSuccessEvent(restaurantModel));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }));
    }

    public void getSearchResult() {
        apiService.retrieveSearchResult(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<SearchModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<SearchModel> response) {
                        SearchModel searchModel = response.body();
                        EventBus.getDefault().post(new OnSearchSuccessEvent(searchModel));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }), getSearchInputParams());
    }

    private Map<String, Object> getSearchInputParams() {
        Map<String, Object> map = new HashMap<>();
        map.put(StaticValues.SearchApiKey.ENTITY_ID_KEY, 280);
        map.put(StaticValues.SearchApiKey.ENTITY_TYPE_KEY, "city");
        map.put(StaticValues.SearchApiKey.Q_KEY, "cafe");
        map.put(StaticValues.SearchApiKey.START_KEY, 0);
        map.put(StaticValues.SearchApiKey.COUNT_KEY, 5);
        map.put(StaticValues.SearchApiKey.LAT_KEY, 40.732013);
        map.put(StaticValues.SearchApiKey.LON_KEY, -73.996155);
        map.put(StaticValues.SearchApiKey.RADIUS_KEY, 500000);
        map.put(StaticValues.SearchApiKey.CUISINES_KEY, "cafe");
        map.put(StaticValues.SearchApiKey.ESTABLISHMENT_TYPE_KEY, 31);
        map.put(StaticValues.SearchApiKey.COLLECTION_ID_KEY, 1);
        map.put(StaticValues.SearchApiKey.CATEGORY_KEY, 3);
        map.put(StaticValues.SearchApiKey.SORT_KEY, "rating");

        return map;
    }
}
