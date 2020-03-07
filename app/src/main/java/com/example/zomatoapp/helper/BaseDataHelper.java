package com.example.zomatoapp.helper;

import com.example.zomatoapp.dataModel.RequestDataModel;

public abstract class BaseDataHelper implements DataHelper {
    @Override
    public void retrieveData(RequestDataModel requestDataModel) {
//        if (requestDataModel.isRequireCache()) {
//            CachedData cachedData = retrieveCacheDataImpl(requestDataModel);
//            if (cachedData != null && cachedData.isCacheValid) {
//                if (!cachedData.isCacheExpired || !hasInternetConnection()) {
//                    needToRefreshData = false  || requestDataModel.isDisruptionAcceptRefresh();
//                    EventBus.getDefault().post(new OnDataSuccessEvent(requestDataModel, cachedData.model));
//                } else {
//                    EventBus.getDefault().post(new OnCacheDataReadyEvent(requestDataModel, cachedData.model));
//                }
//            }
//        }
//
//        if (needToRefreshData) {
//            if (hasInternetConnection()) {
//                retrieveDataImpl(requestDataModel);
//            } else {
//                onDataFail(requestDataModel, OnDataFailEvent.NO_INTERNET_ERROR, null);
//            }
//        }
    }

    @Override
    public void deleteAllData(RequestDataModel requestDataModel) {

    }

    protected abstract void retrieveCacheDataImpl(RequestDataModel requestDataModel);

    protected abstract void retrieveDataImpl(RequestDataModel requestDataModel);
}
