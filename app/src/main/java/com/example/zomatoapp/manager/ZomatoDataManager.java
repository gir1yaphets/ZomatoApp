package com.example.zomatoapp.manager;

import com.example.zomatoapp.ZomatoApplication;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;
import com.example.zomatoapp.utils.CommonUtil;
import com.google.gson.Gson;

public class ZomatoDataManager extends BaseDataManager<DbSearchModel> {
    @Override
    public Object updateData(String signinID, Object responseData) {
        return update((DbSearchModel) responseData);
    }

    @Override
    public void deleteAllData() {
        deleteAll(DbSearchModel.class);
    }

    @Override
    public long getCount() {
        return getCount(DbSearchModel.class);
    }

    private DbSearchModel updateOrInsert2Db(SearchModel searchModel) {
        return updateObjectFromJson(DbSearchModel.class, new Gson().toJson(searchModel));
    }

    public DbSearchModel queryRestaurants(SearchRequestModel requestDataModel) {
        String compoundKey = CommonUtil.getCompoundKey(ZomatoApplication.getContext(), requestDataModel.getCityId(), requestDataModel.getCategoryId());
        return query(DbSearchModel.class, compoundKey, "id");
    }
}
