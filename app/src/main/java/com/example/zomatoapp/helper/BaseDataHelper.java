package com.example.zomatoapp.helper;

import com.example.zomatoapp.ZomatoApplication;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.manager.BaseDataManager;
import com.example.zomatoapp.utils.CommonUtil;

import org.greenrobot.eventbus.EventBus;

import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS;
import static com.example.zomatoapp.dataModel.requestModel.RequestDataModel.ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS;

public abstract class BaseDataHelper implements DataHelper {
    protected BaseDataManager dataManager;

    @Override
    public void retrieveData(RequestDataModel requestDataModel) {
        boolean needToRefreshData = true;
        if (requestDataModel.isRequireCache() || !hasInternetConnection()) {
            CachedData cachedData = retrieveCacheDataImpl(requestDataModel);
            if (cachedData != null && cachedData.isCacheValid && !cachedData.isCacheExpired) {
                needToRefreshData = false;

                String actionType = requestDataModel.getActionType();
                if (ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS.equals(actionType) || ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS.equals(actionType)) {
                    EventBus.getDefault().post(new OnSearchSuccessEvent((SearchRequestModel) requestDataModel, (DbSearchModel) cachedData.model));
                } else if (ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS.equals(actionType) || ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS.equals(actionType)) {
                    //post event collections
                }
            }
        }

        if (needToRefreshData) {
            retrieveDataImpl(requestDataModel);
        }
    }

    @Override
    public void deleteAllData(RequestDataModel requestDataModel) {
        dataManager.deleteAllData();
    }

    protected boolean hasInternetConnection() {
        return CommonUtil.isNetworkAvailable(ZomatoApplication.getContext());
    }

    protected abstract CachedData retrieveCacheDataImpl(RequestDataModel requestDataModel);

    protected abstract void retrieveDataImpl(RequestDataModel requestDataModel);

    public static class CachedData {
        public Object model;
        public boolean isCacheExpired;
        public boolean isCacheValid;

        public CachedData(Object model, boolean isCacheExpired, boolean isCacheValid) {
            this.model = model;
            this.isCacheExpired = isCacheExpired;
            this.isCacheValid = isCacheValid;
        }
    }
}
