package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.requestModel.CollectionRequestModel;

public class OnCollectionsSuccessEvent {
    private CollectionListModel collectionListModel;
    private CollectionRequestModel collectionRequestModel;

    public OnCollectionsSuccessEvent(CollectionRequestModel collectionRequestModel, CollectionListModel collectionListModel) {
        this.collectionRequestModel = collectionRequestModel;
        this.collectionListModel = collectionListModel;
    }

    public CollectionListModel getCollectionListModel() {
        return collectionListModel;
    }

    public CollectionRequestModel getCollectionRequestModel() {
        return collectionRequestModel;
    }
}
