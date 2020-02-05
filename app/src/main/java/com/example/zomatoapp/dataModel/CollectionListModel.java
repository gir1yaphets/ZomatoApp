package com.example.zomatoapp.dataModel;

import java.util.List;

public class CollectionListModel {
    private int has_more;
    private String share_url;
    private String display_text;
    private int has_total;
    private boolean user_has_addresses;
    private List<Collections> collections;

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public boolean isUser_has_addresses() {
        return user_has_addresses;
    }

    public void setUser_has_addresses(boolean user_has_addresses) {
        this.user_has_addresses = user_has_addresses;
    }

    public List<Collections> getCollections() {
        return collections;
    }

    public void setCollections(List<Collections> collections) {
        this.collections = collections;
    }

    public static class Collections {
        private CollectionModel collection;

        public CollectionModel getCollection() {
            return collection;
        }

        public void setCollection(CollectionModel collection) {
            this.collection = collection;
        }
    }
}
