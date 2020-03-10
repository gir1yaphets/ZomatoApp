package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.dataModel.requestModel.SearchRequestModel;

public class OnSearchSuccessEvent {
    private DbSearchModel dbSearchModel;
    private SearchRequestModel searchRequestModel;

    public OnSearchSuccessEvent(SearchRequestModel requestModel, DbSearchModel dbSearchModel) {
        this.searchRequestModel = requestModel;
        this.dbSearchModel = dbSearchModel;
    }

    public DbSearchModel getDbSearchModel() {
        return dbSearchModel;
    }

    public void setDbSearchModel(DbSearchModel dbSearchModel) {
        this.dbSearchModel = dbSearchModel;
    }

    public SearchRequestModel getSearchRequestModel() {
        return searchRequestModel;
    }

    public void setSearchRequestModel(SearchRequestModel searchRequestModel) {
        this.searchRequestModel = searchRequestModel;
    }
}
