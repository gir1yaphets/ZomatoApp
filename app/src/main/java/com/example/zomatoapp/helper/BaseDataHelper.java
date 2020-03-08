package com.example.zomatoapp.helper;

import com.example.zomatoapp.ZomatoApplication;
import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;
import com.example.zomatoapp.manager.BaseDataManager;
import com.example.zomatoapp.utils.CommonUtil;

public abstract class BaseDataHelper implements DataHelper {
    protected BaseDataManager dataManager;

    @Override
    public void retrieveData(RequestDataModel requestDataModel) {
        boolean needToRefreshData = true;
        if (requestDataModel.isRequireCache()) {
            CachedData cachedData = retrieveCacheDataImpl(requestDataModel);
            if (cachedData != null && cachedData.isCacheValid && !cachedData.isCacheExpired) {
                needToRefreshData = false;
                //post event
            }
        }

        if (needToRefreshData) {
            if (hasInternetConnection()) {
                retrieveDataImpl(requestDataModel);
            }
        }
    }

    @Override
    public void deleteAllData(RequestDataModel requestDataModel) {
        dataManager.deleteAllData();

        //post event
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
