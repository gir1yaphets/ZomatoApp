package com.example.zomatoapp.viewModel;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.view.View;

import com.example.zomatoapp.activities.CollectionActivity;
import com.example.zomatoapp.activities.CollectionListActivity;
import com.example.zomatoapp.activities.RestaurantActivity;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.realmObject.DbRestaurantModel;
import com.example.zomatoapp.dataModel.realmObject.DbRestaurantsModel;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.dataModel.requestModel.CollectionRequestModel;
import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.helper.ZomatoDataHelper;
import com.example.zomatoapp.ui.CollectionListAdapter;
import com.example.zomatoapp.ui.RestaurantListAdapter;
import com.example.zomatoapp.utils.StaticValues;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;

public class CommonViewModel implements RestaurantItemViewModel.OnRestaurantSelectListener, CollectionItemViewModel.OnCollectionSelectListener {
    private Context context;
    private ZomatoDataHelper zomatoDataHelper;

    private CollectionListAdapter collectionAdapter;
    private List<CollectionItemViewModel> collectionData = new ArrayList<>();

    private RestaurantListAdapter restaurantListAdapter;
    private List<RestaurantItemViewModel> restaurantData = new ArrayList<>();

    public ObservableField<Integer> cityId = new ObservableField<>(0);
    public ObservableField<String> cityName = new ObservableField<>();

    private CollectionListModel collectionListModel;

    public CommonViewModel(Context context) {
        this.context = context;
        zomatoDataHelper = new ZomatoDataHelper(context);

        collectionAdapter = new CollectionListAdapter(collectionData);
        restaurantListAdapter = new RestaurantListAdapter(restaurantData);
    }

    public void retrieveRestaurantInfo(int id) {
        zomatoDataHelper.retrieveRestaurant(id);
    }

    public void getCityInfo(int categoryId) {
        zomatoDataHelper.getCityInfo(categoryId, LocationHelper.getInstance().getCurrentLocation());
    }

    public void getSearchResult(int cityId, int collectionId, int categoryId, Location location) {
        SearchRequestModel searchRequestModel = new SearchRequestModel(RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS);

        searchRequestModel.setRequireCache(false);
        searchRequestModel.setCityId(cityId);
        searchRequestModel.setCollectionId(collectionId);
        searchRequestModel.setCategoryId(categoryId);
        searchRequestModel.setLocation(location);

        zomatoDataHelper.retrieveData(searchRequestModel);
    }

    public void retrieveCollections(int cityId, int categoryId, int count) {
        CollectionRequestModel collectionRequestModel = new CollectionRequestModel(RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS);
        collectionRequestModel.setCityId(cityId);
        collectionRequestModel.setCategoryId(categoryId);
        collectionRequestModel.setCount(count);

        zomatoDataHelper.retrieveData(collectionRequestModel);
    }

    public void updateCollectionViewModel(CollectionListModel collectionListModel) {
        this.collectionListModel = collectionListModel;

        for (CollectionListModel.Collections collectionModel : collectionListModel.getCollections()) {
            CollectionItemViewModel viewModel = new CollectionItemViewModel();
            viewModel.setId(collectionModel.getCollection().getCollectionId());
            viewModel.collectionTitle.set(collectionModel.getCollection().getTitle());
            viewModel.imageUrl.set(collectionModel.getCollection().getImageUrl());
            viewModel.setListener(this);
            collectionData.add(viewModel);
        }

        collectionRefresh();
    }

    public void updateRestaurantViewModel(DbSearchModel dbSearchModel) {
        for (DbRestaurantsModel restaurantsModel : dbSearchModel.getRestaurants()) {
            DbRestaurantModel restaurantModel = restaurantsModel.getRestaurant();
            RestaurantItemViewModel viewModel = new RestaurantItemViewModel();
            viewModel.setId(Integer.parseInt(restaurantModel.getId()));
            viewModel.name.set(restaurantModel.getName());
            viewModel.description.set(restaurantModel.getCuisines());
            viewModel.status.set(restaurantModel.getTimings());
            viewModel.location.set(restaurantModel.getLocation().getCity());
            viewModel.imageUrl.set(restaurantModel.getThumb());
            viewModel.rating.set(restaurantModel.getUserRating().getAggregateRating());
            viewModel.setListener(this);
            int priceForTwo = restaurantModel.getAverageCostForTwo();
            String priceText = "$" + priceForTwo + " for two people(approx.)";
            viewModel.price.set(priceText);
            restaurantData.add(viewModel);
        }

        restRefresh();
    }

    public CollectionListAdapter getCollectionAdapter() {
        return collectionAdapter;
    }

    public RestaurantListAdapter getRestaurantListAdapter() {
        return restaurantListAdapter;
    }

    public void collectionRefresh() {
        collectionAdapter.setData(collectionData);
    }

    public void restRefresh() {
        restaurantListAdapter.setData(restaurantData);
    }

    @Override
    public void onRestaurantSelect(int id) {
        Intent intent = new Intent(context, RestaurantActivity.class);
        intent.putExtra(StaticValues.EXTRA_REST_ID, id);
        context.startActivity(intent);
    }

    @Override
    public void onCollectionSelect(int id, String image) {
        Intent intent = new Intent(context, CollectionActivity.class);
        intent.putExtra(StaticValues.EXTRA_COLLECTION_ID, id);
        intent.putExtra(StaticValues.EXTRA_CITY_ID, cityId.get());
        intent.putExtra(StaticValues.EXTRA_COLLECTION_IMAGE, image);
        context.startActivity(intent);
    }

    public void onSeeAllClick(View view) {
        Intent intent = new Intent(context, CollectionListActivity.class);
        intent.putExtra(StaticValues.EXTRA_CITY_ID, cityId.get());
        intent.putExtra(StaticValues.EXTRA_COLLECTION_LIST, collectionListModel);
        context.startActivity(intent);
    }
}
