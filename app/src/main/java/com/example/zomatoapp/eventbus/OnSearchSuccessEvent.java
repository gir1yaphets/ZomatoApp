package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.SearchModel;

public class OnSearchSuccessEvent {
    private SearchModel searchModel;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private int category;

    public OnSearchSuccessEvent(SearchModel searchModel, int category) {
        this.searchModel = searchModel;
        this.category = category;
    }

    public SearchModel getSearchModel() {
        return searchModel;
    }
}
