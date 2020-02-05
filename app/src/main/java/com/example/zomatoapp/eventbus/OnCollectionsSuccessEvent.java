package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.CollectionListModel;

public class OnCollectionsSuccessEvent {
    private CollectionListModel collectionListModel;

    public OnCollectionsSuccessEvent(CollectionListModel collectionListModel) {
        this.collectionListModel = collectionListModel;
    }

    public CollectionListModel getCollectionListModel() {
        return collectionListModel;
    }
}
