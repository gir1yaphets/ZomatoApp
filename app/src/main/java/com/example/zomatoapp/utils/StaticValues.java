package com.example.zomatoapp.utils;

public class StaticValues {
    public static final String BASE_URL = "https://developers.zomato.com/api/";

    public static final String API_VERSION = "v2.1";

    public static final String USER_KEY_VALUE = "a93dc79716fee39ae34c85810a9dd15f";

    public static final String USER_KEY = "user-key";

    /**
     * For extra keys
     */
    public static final String EXTRA_REST_ID = "EXTRA_REST_ID";

    public static final String EXTRA_CITY_ID = "EXTRA_CITY_ID";

    public static final String EXTRA_COLLECTION_IMAGE = "EXTRA_COLLECTION_IMAGE";

    public static final String EXTRA_COLLECTION_ID = "EXTRA_COLLECTION_ID";

    public static final String EXTRA_COLLECTION_LIST = "EXTRA_COLLECTION_LIST";

    public static final String EMAIL_DEEP_LINK = "https://www.example.zomatoapp/finishSignUp?cartId=1234";

    public static final String PACKAGE_NAME = "com.example.zomatoapp";

    /**
     * For SharedPreference Key
     */
    public static final String SHARE_PRE_KEY_UUID = "SHARE_PRE_KEY_UUID";

    public static final String SHARE_PRE_KEY_LAST_TIMESTAMP = "SHARE_PRE_KEY_LAST_TIMESTAMP";


    public static final String DEFAULT_CHANNEL_ID = "all";

    /**
     * For api request
     */
    public static class LocationKey {
        public static final String LAT_KEY = "lat";

        public static final String LON_KEY = "lon";
    }

    public static class SearchApiKey {

        public static final String ENTITY_ID_KEY = "entity_id";

        public static final String ENTITY_TYPE_KEY = "entity_type";

        public static final String Q_KEY = "q";

        public static final String START_KEY = "start";

        public static final String COUNT_KEY = "count";

        public static final String RADIUS_KEY = "radius";

        public static final String CUISINES_KEY = "cuisines";

        public static final String ESTABLISHMENT_TYPE_KEY = "establishment_type";

        public static final String COLLECTION_ID_KEY = "collection_id";

        public static final String CATEGORY_KEY = "category";

        public static final String SORT_KEY = "sort";

        public static final String ORDER_KEY = "order";
    }

    public static class CityApiKey {
        public static final String COUNT_KEY = "count";

        public static final String Q_KEY = "q";

        public static final String CITY_IDS_KEY = "city_ids";
    }
}
