package com.example.zomatoapp.dataModel;

import java.util.List;

public class RestaurantModel {

    /**
     * R : {"has_menu_status":{"delivery":-1,"takeaway":-1},"res_id":16774318}
     * apikey : a93dc79716fee39ae34c85810a9dd15f
     * id : 16774318
     * name : Otto Enoteca Pizzeria
     * url : https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
     * location : {"address":"One Fifth Avenue at 8th Street, Greenwich Village 10003","locality":"Greenwich Village","city":"New York City","city_id":280,"latitude":"40.7318200000","longitude":"-73.9965400000","zipcode":"10003","country_id":216,"locality_verbose":"Greenwich Village"}
     * switch_to_order_menu : 0
     * cuisines : Pizza, Italian
     * timings : 12 Noon to 11 PM (Mon-Thu), 11:30 AM to 12 Midnight (Fri-Sat), 11:30 AM to 11 PM (Sun)
     * average_cost_for_two : 40
     * price_range : 3
     * currency : $
     * highlights : ["Lunch","Serves Alcohol","Delivery","Dinner","Takeaway Available","Credit Card","Fullbar","Vegetarian Friendly","Indoor Seating","Table booking recommended"]
     * offers : []
     * opentable_support : 0
     * is_zomato_book_res : 0
     * mezzo_provider : OTHER
     * is_book_form_web_view : 0
     * book_form_web_view_url :
     * book_again_url :
     * thumb : https://b.zmtcdn.com/data/pictures/8/16774318/b16e382e9f6696f911b600b7e5ca6839.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A
     * user_rating : {"aggregate_rating":"4.4","rating_text":"Very Good","rating_color":"5BA829","rating_obj":{"title":{"text":"4.4"},"bg_color":{"type":"lime","tint":"700"}},"votes":"568"}
     * all_reviews_count : 97
     * photos_url : https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop
     * photo_count : 88
     * photos : [{"photo":{"id":"u_A1MTE1MTYxNDYz","url":"https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=112&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_MTg5MzExNANjk1","url":"https://b.zmtcdn.com/data/reviews_photos/083/75cf4cc7bab00e8f02c8b041538e0083_1442094959.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/083/75cf4cc7bab00e8f02c8b041538e0083_1442094959.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=248&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095015,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_jIzMjMwNjYxMTg","url":"https://b.zmtcdn.com/data/reviews_photos/abc/f17134ad05fc55104c9b97fb6eb28abc_1442095175.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/abc/f17134ad05fc55104c9b97fb6eb28abc_1442095175.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=190&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_NDk0MDcxNjMyNj","url":"https://b.zmtcdn.com/data/reviews_photos/b7a/a25f1e217e1f2902e915415c0a9e6b7a_1442095151.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/b7a/a25f1e217e1f2902e915415c0a9e6b7a_1442095151.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_DYzOTk4NjUzODY","url":"https://b.zmtcdn.com/data/reviews_photos/2ba/c30a34383235946ac4a160357b8b82ba_1442095138.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/2ba/c30a34383235946ac4a160357b8b82ba_1442095138.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=111&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_MDgxMzE2NzU4Mz","url":"https://b.zmtcdn.com/data/reviews_photos/211/26e5681e26cb4a00dd95834baf46d211_1442095077.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/211/26e5681e26cb4a00dd95834baf46d211_1442095077.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=175&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_OTkyNzM0MjQxNj","url":"https://b.zmtcdn.com/data/reviews_photos/4d4/6ffaa05e3908625cddf9d39554bfb4d4_1442095065.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/4d4/6ffaa05e3908625cddf9d39554bfb4d4_1442095065.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=115&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_kzOTI4MzMwMTE5","url":"https://b.zmtcdn.com/data/reviews_photos/431/d4b614cc658092af60868c6fee514431_1442094957.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/431/d4b614cc658092af60868c6fee514431_1442094957.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=164&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095015,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_zU0OTMzODAyNTU","url":"https://b.zmtcdn.com/data/reviews_photos/057/eb5a38759ffcfbcd1c8732dd7be65057_1442094604.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/057/eb5a38759ffcfbcd1c8732dd7be65057_1442094604.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442094684,"friendly_time":"Sep 13, 2015","width":640,"height":640}},{"photo":{"id":"u_NTYxNzkyMzE4MD","url":"https://b.zmtcdn.com/data/reviews_photos/d42/b6377cab878a000b3f4f22d4e29fed42_1442094972.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/d42/b6377cab878a000b3f4f22d4e29fed42_1442094972.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=237&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095015,"friendly_time":"Sep 13, 2015","width":640,"height":640}}]
     * menu_url : https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop
     * featured_image : https://b.zmtcdn.com/data/pictures/8/16774318/b16e382e9f6696f911b600b7e5ca6839.jpg
     * has_online_delivery : 0
     * is_delivering_now : 0
     * include_bogo_offers : true
     * deeplink : zomato://restaurant/16774318
     * is_table_reservation_supported : 0
     * has_table_booking : 0
     * events_url : https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
     * phone_numbers : (212) 995-9559, (212) 995-9559
     * all_reviews : {"reviews":[{"review":[]},{"review":[]},{"review":[]},{"review":[]},{"review":[]}]}
     * establishment : ["Pizzeria"]
     */

    private RBean R;
    private String apikey;
    private String id;
    private String name;
    private String url;
    private LocationBean location;
    private int switch_to_order_menu;
    private String cuisines;
    private String timings;
    private int average_cost_for_two;
    private int price_range;
    private String currency;
    private int opentable_support;
    private int is_zomato_book_res;
    private String mezzo_provider;
    private int is_book_form_web_view;
    private String book_form_web_view_url;
    private String book_again_url;
    private String thumb;
    private UserRatingBean user_rating;
    private int all_reviews_count;
    private String photos_url;
    private int photo_count;
    private String menu_url;
    private String featured_image;
    private int has_online_delivery;
    private int is_delivering_now;
    private boolean include_bogo_offers;
    private String deeplink;
    private int is_table_reservation_supported;
    private int has_table_booking;
    private String events_url;
    private String phone_numbers;
    private AllReviewsBean all_reviews;
    private List<String> highlights;
    private List<?> offers;
    private List<PhotosBean> photos;
    private List<String> establishment;

    public RBean getR() {
        return R;
    }

    public void setR(RBean R) {
        this.R = R;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public int getSwitch_to_order_menu() {
        return switch_to_order_menu;
    }

    public void setSwitch_to_order_menu(int switch_to_order_menu) {
        this.switch_to_order_menu = switch_to_order_menu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public int getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(int average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public int getPrice_range() {
        return price_range;
    }

    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getOpentable_support() {
        return opentable_support;
    }

    public void setOpentable_support(int opentable_support) {
        this.opentable_support = opentable_support;
    }

    public int getIs_zomato_book_res() {
        return is_zomato_book_res;
    }

    public void setIs_zomato_book_res(int is_zomato_book_res) {
        this.is_zomato_book_res = is_zomato_book_res;
    }

    public String getMezzo_provider() {
        return mezzo_provider;
    }

    public void setMezzo_provider(String mezzo_provider) {
        this.mezzo_provider = mezzo_provider;
    }

    public int getIs_book_form_web_view() {
        return is_book_form_web_view;
    }

    public void setIs_book_form_web_view(int is_book_form_web_view) {
        this.is_book_form_web_view = is_book_form_web_view;
    }

    public String getBook_form_web_view_url() {
        return book_form_web_view_url;
    }

    public void setBook_form_web_view_url(String book_form_web_view_url) {
        this.book_form_web_view_url = book_form_web_view_url;
    }

    public String getBook_again_url() {
        return book_again_url;
    }

    public void setBook_again_url(String book_again_url) {
        this.book_again_url = book_again_url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRatingBean getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRatingBean user_rating) {
        this.user_rating = user_rating;
    }

    public int getAll_reviews_count() {
        return all_reviews_count;
    }

    public void setAll_reviews_count(int all_reviews_count) {
        this.all_reviews_count = all_reviews_count;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public int getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(int photo_count) {
        this.photo_count = photo_count;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public int getHas_online_delivery() {
        return has_online_delivery;
    }

    public void setHas_online_delivery(int has_online_delivery) {
        this.has_online_delivery = has_online_delivery;
    }

    public int getIs_delivering_now() {
        return is_delivering_now;
    }

    public void setIs_delivering_now(int is_delivering_now) {
        this.is_delivering_now = is_delivering_now;
    }

    public boolean isInclude_bogo_offers() {
        return include_bogo_offers;
    }

    public void setInclude_bogo_offers(boolean include_bogo_offers) {
        this.include_bogo_offers = include_bogo_offers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public int getIs_table_reservation_supported() {
        return is_table_reservation_supported;
    }

    public void setIs_table_reservation_supported(int is_table_reservation_supported) {
        this.is_table_reservation_supported = is_table_reservation_supported;
    }

    public int getHas_table_booking() {
        return has_table_booking;
    }

    public void setHas_table_booking(int has_table_booking) {
        this.has_table_booking = has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    public AllReviewsBean getAll_reviews() {
        return all_reviews;
    }

    public void setAll_reviews(AllReviewsBean all_reviews) {
        this.all_reviews = all_reviews;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    public List<?> getOffers() {
        return offers;
    }

    public void setOffers(List<?> offers) {
        this.offers = offers;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<String> getEstablishment() {
        return establishment;
    }

    public void setEstablishment(List<String> establishment) {
        this.establishment = establishment;
    }

    public static class RBean {
        /**
         * has_menu_status : {"delivery":-1,"takeaway":-1}
         * res_id : 16774318
         */

        private HasMenuStatusBean has_menu_status;
        private int res_id;

        public HasMenuStatusBean getHas_menu_status() {
            return has_menu_status;
        }

        public void setHas_menu_status(HasMenuStatusBean has_menu_status) {
            this.has_menu_status = has_menu_status;
        }

        public int getRes_id() {
            return res_id;
        }

        public void setRes_id(int res_id) {
            this.res_id = res_id;
        }

        public static class HasMenuStatusBean {
            /**
             * delivery : -1
             * takeaway : -1
             */

            private int delivery;
            private int takeaway;

            public int getDelivery() {
                return delivery;
            }

            public void setDelivery(int delivery) {
                this.delivery = delivery;
            }

            public int getTakeaway() {
                return takeaway;
            }

            public void setTakeaway(int takeaway) {
                this.takeaway = takeaway;
            }
        }
    }

    public static class LocationBean {
        /**
         * address : One Fifth Avenue at 8th Street, Greenwich Village 10003
         * locality : Greenwich Village
         * city : New York City
         * city_id : 280
         * latitude : 40.7318200000
         * longitude : -73.9965400000
         * zipcode : 10003
         * country_id : 216
         * locality_verbose : Greenwich Village
         */

        private String address;
        private String locality;
        private String city;
        private int city_id;
        private String latitude;
        private String longitude;
        private String zipcode;
        private int country_id;
        private String locality_verbose;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public String getLocality_verbose() {
            return locality_verbose;
        }

        public void setLocality_verbose(String locality_verbose) {
            this.locality_verbose = locality_verbose;
        }
    }

    public static class UserRatingBean {
        /**
         * aggregate_rating : 4.4
         * rating_text : Very Good
         * rating_color : 5BA829
         * rating_obj : {"title":{"text":"4.4"},"bg_color":{"type":"lime","tint":"700"}}
         * votes : 568
         */

        private String aggregate_rating;
        private String rating_text;
        private String rating_color;
        private RatingObjBean rating_obj;
        private String votes;

        public String getAggregate_rating() {
            return aggregate_rating;
        }

        public void setAggregate_rating(String aggregate_rating) {
            this.aggregate_rating = aggregate_rating;
        }

        public String getRating_text() {
            return rating_text;
        }

        public void setRating_text(String rating_text) {
            this.rating_text = rating_text;
        }

        public String getRating_color() {
            return rating_color;
        }

        public void setRating_color(String rating_color) {
            this.rating_color = rating_color;
        }

        public RatingObjBean getRating_obj() {
            return rating_obj;
        }

        public void setRating_obj(RatingObjBean rating_obj) {
            this.rating_obj = rating_obj;
        }

        public String getVotes() {
            return votes;
        }

        public void setVotes(String votes) {
            this.votes = votes;
        }

        public static class RatingObjBean {
            /**
             * title : {"text":"4.4"}
             * bg_color : {"type":"lime","tint":"700"}
             */

            private TitleBean title;
            private BgColorBean bg_color;

            public TitleBean getTitle() {
                return title;
            }

            public void setTitle(TitleBean title) {
                this.title = title;
            }

            public BgColorBean getBg_color() {
                return bg_color;
            }

            public void setBg_color(BgColorBean bg_color) {
                this.bg_color = bg_color;
            }

            public static class TitleBean {
                /**
                 * text : 4.4
                 */

                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class BgColorBean {
                /**
                 * type : lime
                 * tint : 700
                 */

                private String type;
                private String tint;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTint() {
                    return tint;
                }

                public void setTint(String tint) {
                    this.tint = tint;
                }
            }
        }
    }

    public static class AllReviewsBean {
        private List<ReviewsBean> reviews;

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public static class ReviewsBean {
            private List<?> review;

            public List<?> getReview() {
                return review;
            }

            public void setReview(List<?> review) {
                this.review = review;
            }
        }
    }

    public static class PhotosBean {
        /**
         * photo : {"id":"u_A1MTE1MTYxNDYz","url":"https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=112&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"},"res_id":16774318,"caption":"","timestamp":1442095369,"friendly_time":"Sep 13, 2015","width":640,"height":640}
         */

        private PhotoBean photo;

        public PhotoBean getPhoto() {
            return photo;
        }

        public void setPhoto(PhotoBean photo) {
            this.photo = photo;
        }

        public static class PhotoBean {
            /**
             * id : u_A1MTE1MTYxNDYz
             * url : https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A
             * thumb_url : https://b.zmtcdn.com/data/reviews_photos/ef8/d451664187858a70dd79bd8750e0fef8_1442095040.JPG?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=112&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore
             * user : {"name":"Feisty Foodie","zomato_handle":"feistyfoodie","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20641164"}
             * res_id : 16774318
             * caption :
             * timestamp : 1442095369
             * friendly_time : Sep 13, 2015
             * width : 640
             * height : 640
             */

            private String id;
            private String url;
            private String thumb_url;
            private UserBean user;
            private int res_id;
            private String caption;
            private int timestamp;
            private String friendly_time;
            private int width;
            private int height;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public int getRes_id() {
                return res_id;
            }

            public void setRes_id(int res_id) {
                this.res_id = res_id;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }

            public String getFriendly_time() {
                return friendly_time;
            }

            public void setFriendly_time(String friendly_time) {
                this.friendly_time = friendly_time;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public static class UserBean {
                /**
                 * name : Feisty Foodie
                 * zomato_handle : feistyfoodie
                 * foodie_level : Connoisseur
                 * foodie_level_num : 13
                 * foodie_color : e95151
                 * profile_url : https://www.zomato.com/feistyfoodie?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
                 * profile_image : https://b.zmtcdn.com/data/user_profile_pictures/7d3/8268699d29fcede843861dd0c07b27d3.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A
                 * profile_deeplink : zomato://u/20641164
                 */

                private String name;
                private String zomato_handle;
                private String foodie_level;
                private int foodie_level_num;
                private String foodie_color;
                private String profile_url;
                private String profile_image;
                private String profile_deeplink;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getZomato_handle() {
                    return zomato_handle;
                }

                public void setZomato_handle(String zomato_handle) {
                    this.zomato_handle = zomato_handle;
                }

                public String getFoodie_level() {
                    return foodie_level;
                }

                public void setFoodie_level(String foodie_level) {
                    this.foodie_level = foodie_level;
                }

                public int getFoodie_level_num() {
                    return foodie_level_num;
                }

                public void setFoodie_level_num(int foodie_level_num) {
                    this.foodie_level_num = foodie_level_num;
                }

                public String getFoodie_color() {
                    return foodie_color;
                }

                public void setFoodie_color(String foodie_color) {
                    this.foodie_color = foodie_color;
                }

                public String getProfile_url() {
                    return profile_url;
                }

                public void setProfile_url(String profile_url) {
                    this.profile_url = profile_url;
                }

                public String getProfile_image() {
                    return profile_image;
                }

                public void setProfile_image(String profile_image) {
                    this.profile_image = profile_image;
                }

                public String getProfile_deeplink() {
                    return profile_deeplink;
                }

                public void setProfile_deeplink(String profile_deeplink) {
                    this.profile_deeplink = profile_deeplink;
                }
            }
        }
    }
}