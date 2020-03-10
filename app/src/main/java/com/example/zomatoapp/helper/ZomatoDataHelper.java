package com.example.zomatoapp.helper;

import android.content.Context;
import android.location.Location;

import com.example.zomatoapp.dataModel.AllReviewsModel;
import com.example.zomatoapp.dataModel.CityModel;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.dataModel.requestModel.CollectionRequestModel;
import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;
import com.example.zomatoapp.eventbus.OnCitySuccessEvent;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.eventbus.OnReviewSuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.manager.ZomatoDataManager;
import com.example.zomatoapp.network.ApiService;
import com.example.zomatoapp.network.RetrofitApiCallback;
import com.example.zomatoapp.network.RetrofitErrorModel;
import com.example.zomatoapp.utils.CommonUtil;
import com.example.zomatoapp.utils.StaticValues;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Response;

import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS;

public class ZomatoDataHelper extends BaseDataHelper {
    private static final String TAG = ZomatoDataHelper.class.getName();

    private Context mContext;
    private ApiService apiService;

    public ZomatoDataHelper(Context context) {
        mContext = context;
        apiService = ApiService.getInstance();

        dataManager = new ZomatoDataManager();
    }

    public void retrieveCollection(CollectionRequestModel collectionRequestModel) {
        int cityId = collectionRequestModel.getCityId();
        int count = collectionRequestModel.getCount();

        apiService.retrieveCollections(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<CollectionListModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<CollectionListModel> response) {
                        CollectionListModel collectionModelList = response.body();
                        EventBus.getDefault().post(new OnCollectionsSuccessEvent(collectionRequestModel, collectionModelList));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }), cityId, count);
    }

    public void retrieveRestaurant(int id) {
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
                }), id);
    }

    public void getSearchResult(SearchRequestModel searchReqModel) {
        int cityId = searchReqModel.getCityId();
        int categoryId = searchReqModel.getCategoryId();
        int collectionId = searchReqModel.getCollectionId();
        Location location = searchReqModel.getLocation();

        apiService.retrieveSearchResult(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<SearchModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<SearchModel> response) {
                        SearchModel searchModel = response.body();
                        DbSearchModel dbSearchModel = convertSearchData(cityId, categoryId, searchModel);
                        onSearchSuccess(dbSearchModel);

                        EventBus.getDefault().post(new OnSearchSuccessEvent(searchReqModel, dbSearchModel));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }), getSearchInputParams(cityId, 0, 20, collectionId, categoryId, location));
    }

    private void onSearchSuccess(DbSearchModel dbSearchModel) {
        dataManager.updateData("", dbSearchModel);
    }

    private DbSearchModel convertSearchData(int cityId, int categoryId, SearchModel searchModel) {
        Gson gson = new Gson();
        String originalData = gson.toJson(searchModel);

        DbSearchModel dbSearchModel = gson.fromJson(originalData, DbSearchModel.class);
        dbSearchModel.setCategoryId(categoryId);
        dbSearchModel.setId(CommonUtil.getCompoundKey(mContext, cityId, categoryId));
        return dbSearchModel;
    }

    public void getCityInfo(int category, Location location) {
        apiService.retrieveCityInfo(new RetrofitApiCallback<>(
                new RetrofitApiCallback.OnActionHandleListener<CityModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<CityModel> response) {
                        CityModel cityModel = response.body();
                        EventBus.getDefault().post(new OnCitySuccessEvent(category, cityModel));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }), getCityInputParams(location));
    }

    public void getReviews(int resId, int start, int end) {
        apiService.getReviews(new RetrofitApiCallback<>(new RetrofitApiCallback.OnActionHandleListener<AllReviewsModel>() {
                    @Override
                    public void onBeforeHandling() {

                    }

                    @Override
                    public void onSuccess(Response<AllReviewsModel> response) {
                        AllReviewsModel allReviewsModel = response.body();
                        EventBus.getDefault().post(new OnReviewSuccessEvent(allReviewsModel));
                    }

                    @Override
                    public void onError(RetrofitErrorModel errors) {

                    }

                    @Override
                    public void onTechIssueError(Throwable t) {

                    }
                }),
                resId, start, end);
    }

    private Map<String, Object> getCityInputParams(Location location) {
        Map<String, Object> map = new HashMap<>();
        map.put(StaticValues.CityApiKey.Q_KEY, "");
        map.put(StaticValues.CityApiKey.COUNT_KEY, 1);
        map.put(StaticValues.LocationKey.LAT_KEY, location.getLatitude());
        map.put(StaticValues.LocationKey.LON_KEY, location.getLongitude());

        return map;
    }

    private Map<String, Object> getSearchInputParams(int cityId, int start, int count, int collectionId, int categoryId,
                                                     Location location) {
        Map<String, Object> map = new HashMap<>();
        map.put(StaticValues.SearchApiKey.ENTITY_ID_KEY, cityId);
        map.put(StaticValues.SearchApiKey.ENTITY_TYPE_KEY, "city");
        map.put(StaticValues.SearchApiKey.Q_KEY, "");
        map.put(StaticValues.SearchApiKey.START_KEY, start);
        map.put(StaticValues.SearchApiKey.COUNT_KEY, count);
        map.put(StaticValues.LocationKey.LAT_KEY, location.getLatitude());
        map.put(StaticValues.LocationKey.LON_KEY, location.getLongitude());
        map.put(StaticValues.SearchApiKey.RADIUS_KEY, 100000);
        map.put(StaticValues.SearchApiKey.CUISINES_KEY, "");
        if (collectionId != -1) {
            map.put(StaticValues.SearchApiKey.COLLECTION_ID_KEY, collectionId);
        }

        if (categoryId != -1) {
            map.put(StaticValues.SearchApiKey.CATEGORY_KEY, categoryId);
        }

        map.put(StaticValues.SearchApiKey.SORT_KEY, "rating");
        map.put(StaticValues.SearchApiKey.ORDER_KEY, "desc");

        return map;
    }

    @Override
    public CachedData retrieveCacheDataImpl(RequestDataModel requestDataModel) {
        switch (requestDataModel.getActionType()) {
            case ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS:
            case ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS:
                DbSearchModel dbSearchModel = ((ZomatoDataManager) dataManager).queryRestaurants((SearchRequestModel) requestDataModel);
                return new CachedData(dbSearchModel, false, true);

            case ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS:
            case ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS:
                break;
        }

        return null;
    }

    @Override
    protected void retrieveDataImpl(RequestDataModel requestDataModel) {
        switch (requestDataModel.getActionType()) {
            case ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS:
            case ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS:
                SearchRequestModel searchReqModel = (SearchRequestModel) requestDataModel;
                getSearchResult(searchReqModel);
                break;

            case ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS:
            case ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS:
                CollectionRequestModel collectionRequestModel = (CollectionRequestModel) requestDataModel;
                retrieveCollection(collectionRequestModel);
                break;
        }
    }
}
