package com.example.zomatoapp.dataModel.requestModel;

public class RequestDataModel {
    public static final String ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS = "ACTION_MANUAL_RETRIEVE_ALL_RESTAURANTS";
    public static final String ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS = "ACTION_AUTO_RETRIEVE_ALL_RESTAURANTS";

    public static final String ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS = "ACTION_MANUAL_RETRIEVE_ALL_COLLECTIONS";
    public static final String ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS = "ACTION_AUTO_RETRIEVE_ALL_COLLECTIONS";


    private String signinId;
    private long timestamp;
    private String actionType;

    private boolean requireCache = false;

    public RequestDataModel(String actionType) {
        this.actionType = actionType;
    }

    public String getSigninId() {
        return signinId;
    }

    public void setSigninId(String signinId) {
        this.signinId = signinId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public boolean isRequireCache() {
        return requireCache;
    }

    public void setRequireCache(boolean requireCache) {
        this.requireCache = requireCache;
    }
}
