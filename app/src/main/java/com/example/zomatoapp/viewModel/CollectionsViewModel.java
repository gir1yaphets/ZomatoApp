package com.example.zomatoapp.viewModel;

import android.app.Application;
import android.location.Location;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;
import com.example.zomatoapp.helper.ZomatoDataHelper;
import com.example.zomatoapp.ui.RestaurantListAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class CollectionsViewModel extends AndroidViewModel {
    private ZomatoDataHelper zomatoDataHelper;

    private List<RestaurantItemViewModel> restaurantViewModels = new ArrayList<>();

    public MutableLiveData<String> collectionImage = new MutableLiveData<>();

    public RestaurantListAdapter getRestAdapter() {
        return restAdapter;
    }

    private RestaurantListAdapter restAdapter;

    public CollectionsViewModel(@NonNull Application application) {
        super(application);

        zomatoDataHelper = new ZomatoDataHelper(getApplication());
        restAdapter = new RestaurantListAdapter(restaurantViewModels);
    }

    public void retrieveRestaurantsInCollection(int cityId, int collectionId, int categoryId, Location location) {
        SearchRequestModel searchRequestModel = new SearchRequestModel(RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS);

        searchRequestModel.setRequireCache(false);
        searchRequestModel.setCityId(cityId);
        searchRequestModel.setCollectionId(collectionId);
        searchRequestModel.setCategoryId(categoryId);
        searchRequestModel.setLocation(location);

        zomatoDataHelper.retrieveData(searchRequestModel);
    }

    public void addRestItem(RestaurantItemViewModel itemViewModel) {
        restaurantViewModels.add(itemViewModel);
    }

    public void refresh() {
        restAdapter.setData(restaurantViewModels);
    }

    @BindingAdapter({"collectionImageUrl"})
    public static void loadRestImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
