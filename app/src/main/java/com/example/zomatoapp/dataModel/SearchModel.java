package com.example.zomatoapp.dataModel;

import java.util.List;

public class SearchModel {


    private int results_found;
    private int results_start;
    private int results_shown;
    private List<RestaurantsBean> restaurants;

    public int getResults_found() {
        return results_found;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public void setResults_start(int results_start) {
        this.results_start = results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public List<RestaurantsBean> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantsBean> restaurants) {
        this.restaurants = restaurants;
    }

    public static class RestaurantsBean {
        /**
         * restaurant : {"R":{"has_menu_status":{"delivery":-1,"takeaway":-1},"res_id":16781658},"apikey":"3cd639325d52ac58bd09cae0bfa2c607","id":16781658,"name":"Vegetarian Paradise 2","url":"https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"144 W 4th Street, New York 10012","locality":"Greenwich Village","city":"New York City","city_id":280,"latitude":"40.7313500000","longitude":"-74.0005670000","zipcode":"10012","country_id":216,"locality_verbose":"Greenwich Village"},"switch_to_order_menu":0,"cuisines":"Asian, Southern, Vegetarian","timings":"12 Noon to 11 PM (Mon, Tue, Wed, Thu, Sun), 12 Noon to 12 Midnight (Fri-Sat)","average_cost_for_two":75,"price_range":4,"currency":"$","highlights":["Dinner","Lunch","Delivery","Indoor Seating","Vegetarian Friendly"],"offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"https://b.zmtcdn.com/data/res_imagery/16781658_RESTAURANT_6d881df583084ad244397b3bbe648f5e_c.JPG?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A","user_rating":{"aggregate_rating":"3.8","rating_text":"Good","rating_color":"9ACD32","rating_obj":{"title":{"text":"3.8"},"bg_color":{"type":"lime","tint":"600"}},"votes":"51"},"all_reviews_count":12,"photos_url":"https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","photo_count":194,"photos":[{"photo":{"id":"u_MzEyNjQwNjcxNj","url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_MzI3NDQ5OTU0MD","url":"https://b.zmtcdn.com/data/reviews_photos/36e/ecf5bbdbce39a20503b978a2b05e336e_1434661125.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/36e/ecf5bbdbce39a20503b978a2b05e336e_1434661125.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_MzM4MDAwMzY3Mz","url":"https://b.zmtcdn.com/data/reviews_photos/ade/a718a2d4affd981327e579e97fd47ade_1434661131.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/ade/a718a2d4affd981327e579e97fd47ade_1434661131.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_NjAwNjUzNDAyOD","url":"https://b.zmtcdn.com/data/reviews_photos/7dc/4ee731917b5233a0efcb73f1b54237dc.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/7dc/4ee731917b5233a0efcb73f1b54237dc.jpg?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Elena Itameri","foodie_level":"Foodie","foodie_level_num":1,"foodie_color":"ffd35d","profile_url":"https://www.zomato.com/users/elena-itameri-23599389?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/c38/1087e29280a2b32a0216857f0b59bc38.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/23599389"},"res_id":16781658,"caption":"Mango Chicken with Brown Rice","timestamp":1364364946,"friendly_time":"Mar 27, 2013","width":2048,"height":1536}},{"photo":{"id":"u_NjE0OTQyNjczMT","url":"https://b.zmtcdn.com/data/reviews_photos/567/1f5387e41792d29845e91cc14ab96567.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/567/1f5387e41792d29845e91cc14ab96567.jpg?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=406&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Greg","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/users/greg-20777084?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7f8/674e4ee160b5bc161d04b5a55c9f67f8.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20777084"},"res_id":16781658,"caption":"Citrus Cashew Chicken, $11","timestamp":1307178018,"friendly_time":"Jun 04, 2011","width":1530,"height":2048}},{"photo":{"id":"u_NDA4ODg4NzU0MT","url":"https://b.zmtcdn.com/data/reviews_photos/a0c/ed1c63ee4cdaed371cff94a637d52a0c.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/a0c/ed1c63ee4cdaed371cff94a637d52a0c.jpg?impolicy=newcropandfit&cropw=480&croph=480&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Leighton Chamberlin Mann","foodie_level":"Big Foodie","foodie_level_num":5,"foodie_color":"ffae4f","profile_url":"https://www.zomato.com/users/leighton-chamberlin-mann-21001977?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/03e/5baac03348f34b30d5a0bfea0e3ca03e.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/21001977"},"res_id":16781658,"caption":"&quot;salmon&quot; with garlic mashed potatoes and asparagus. Not fishy.","timestamp":1254758190,"friendly_time":"Oct 05, 2009","width":640,"height":480}}],"menu_url":"https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"https://b.zmtcdn.com/data/res_imagery/16781658_RESTAURANT_6d881df583084ad244397b3bbe648f5e_c.JPG","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/16781658","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","phone_numbers":"(212) 260-7141","all_reviews":{"reviews":[{"review":[]},{"review":[]},{"review":[]},{"review":[]},{"review":[]}]},"establishment":["Casual Dining"]}
         */

        private RestaurantBean restaurant;

        public RestaurantBean getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(RestaurantBean restaurant) {
            this.restaurant = restaurant;
        }

        public static class RestaurantBean {
            /**
             * R : {"has_menu_status":{"delivery":-1,"takeaway":-1},"res_id":16781658}
             * apikey : 3cd639325d52ac58bd09cae0bfa2c607
             * id : 16781658
             * name : Vegetarian Paradise 2
             * url : https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             * location : {"address":"144 W 4th Street, New York 10012","locality":"Greenwich Village","city":"New York City","city_id":280,"latitude":"40.7313500000","longitude":"-74.0005670000","zipcode":"10012","country_id":216,"locality_verbose":"Greenwich Village"}
             * switch_to_order_menu : 0
             * cuisines : Asian, Southern, Vegetarian
             * timings : 12 Noon to 11 PM (Mon, Tue, Wed, Thu, Sun), 12 Noon to 12 Midnight (Fri-Sat)
             * average_cost_for_two : 75
             * price_range : 4
             * currency : $
             * highlights : ["Dinner","Lunch","Delivery","Indoor Seating","Vegetarian Friendly"]
             * offers : []
             * opentable_support : 0
             * is_zomato_book_res : 0
             * mezzo_provider : OTHER
             * is_book_form_web_view : 0
             * book_form_web_view_url :
             * book_again_url :
             * thumb : https://b.zmtcdn.com/data/res_imagery/16781658_RESTAURANT_6d881df583084ad244397b3bbe648f5e_c.JPG?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A
             * user_rating : {"aggregate_rating":"3.8","rating_text":"Good","rating_color":"9ACD32","rating_obj":{"title":{"text":"3.8"},"bg_color":{"type":"lime","tint":"600"}},"votes":"51"}
             * all_reviews_count : 12
             * photos_url : https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop
             * photo_count : 194
             * photos : [{"photo":{"id":"u_MzEyNjQwNjcxNj","url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_MzI3NDQ5OTU0MD","url":"https://b.zmtcdn.com/data/reviews_photos/36e/ecf5bbdbce39a20503b978a2b05e336e_1434661125.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/36e/ecf5bbdbce39a20503b978a2b05e336e_1434661125.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_MzM4MDAwMzY3Mz","url":"https://b.zmtcdn.com/data/reviews_photos/ade/a718a2d4affd981327e579e97fd47ade_1434661131.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/ade/a718a2d4affd981327e579e97fd47ade_1434661131.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}},{"photo":{"id":"u_NjAwNjUzNDAyOD","url":"https://b.zmtcdn.com/data/reviews_photos/7dc/4ee731917b5233a0efcb73f1b54237dc.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/7dc/4ee731917b5233a0efcb73f1b54237dc.jpg?impolicy=newcropandfit&cropw=900&croph=900&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Elena Itameri","foodie_level":"Foodie","foodie_level_num":1,"foodie_color":"ffd35d","profile_url":"https://www.zomato.com/users/elena-itameri-23599389?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/c38/1087e29280a2b32a0216857f0b59bc38.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/23599389"},"res_id":16781658,"caption":"Mango Chicken with Brown Rice","timestamp":1364364946,"friendly_time":"Mar 27, 2013","width":2048,"height":1536}},{"photo":{"id":"u_NjE0OTQyNjczMT","url":"https://b.zmtcdn.com/data/reviews_photos/567/1f5387e41792d29845e91cc14ab96567.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/567/1f5387e41792d29845e91cc14ab96567.jpg?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=406&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Greg","foodie_level":"Connoisseur","foodie_level_num":13,"foodie_color":"e95151","profile_url":"https://www.zomato.com/users/greg-20777084?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/7f8/674e4ee160b5bc161d04b5a55c9f67f8.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/20777084"},"res_id":16781658,"caption":"Citrus Cashew Chicken, $11","timestamp":1307178018,"friendly_time":"Jun 04, 2011","width":1530,"height":2048}},{"photo":{"id":"u_NDA4ODg4NzU0MT","url":"https://b.zmtcdn.com/data/reviews_photos/a0c/ed1c63ee4cdaed371cff94a637d52a0c.jpg","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/a0c/ed1c63ee4cdaed371cff94a637d52a0c.jpg?impolicy=newcropandfit&cropw=480&croph=480&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Leighton Chamberlin Mann","foodie_level":"Big Foodie","foodie_level_num":5,"foodie_color":"ffae4f","profile_url":"https://www.zomato.com/users/leighton-chamberlin-mann-21001977?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/03e/5baac03348f34b30d5a0bfea0e3ca03e.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/21001977"},"res_id":16781658,"caption":"&quot;salmon&quot; with garlic mashed potatoes and asparagus. Not fishy.","timestamp":1254758190,"friendly_time":"Oct 05, 2009","width":640,"height":480}}]
             * menu_url : https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop
             * featured_image : https://b.zmtcdn.com/data/res_imagery/16781658_RESTAURANT_6d881df583084ad244397b3bbe648f5e_c.JPG
             * has_online_delivery : 0
             * is_delivering_now : 0
             * include_bogo_offers : true
             * deeplink : zomato://restaurant/16781658
             * is_table_reservation_supported : 0
             * has_table_booking : 0
             * events_url : https://www.zomato.com/new-york-city/vegetarian-paradise-2-greenwich-village/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             * phone_numbers : (212) 260-7141
             * all_reviews : {"reviews":[{"review":[]},{"review":[]},{"review":[]},{"review":[]},{"review":[]}]}
             * establishment : ["Casual Dining"]
             */

            private RBean R;
            private String apikey;
            private int id;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
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
                 * res_id : 16781658
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
                 * address : 144 W 4th Street, New York 10012
                 * locality : Greenwich Village
                 * city : New York City
                 * city_id : 280
                 * latitude : 40.7313500000
                 * longitude : -74.0005670000
                 * zipcode : 10012
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
                 * aggregate_rating : 3.8
                 * rating_text : Good
                 * rating_color : 9ACD32
                 * rating_obj : {"title":{"text":"3.8"},"bg_color":{"type":"lime","tint":"600"}}
                 * votes : 51
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
                     * title : {"text":"3.8"}
                     * bg_color : {"type":"lime","tint":"600"}
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
                         * text : 3.8
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
                         * tint : 600
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
                 * photo : {"id":"u_MzEyNjQwNjcxNj","url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?fit=around%7C640%3A640&crop=640%3A640%3B%2A%2C%2A","thumb_url":"https://b.zmtcdn.com/data/reviews_photos/a84/aee7521e049251a0943952d123a7ba84_1434661121.JPG?impolicy=newcropandfit&cropw=1200&croph=1200&cropoffsetx=0&cropoffsety=0&cropgravity=NorthWest&fitw=200&fith=200&fittype=ignore","user":{"name":"Let's Nom Nom","zomato_handle":"letsnomnomblog","foodie_level":"Connoisseur","foodie_level_num":12,"foodie_color":"e95151","profile_url":"https://www.zomato.com/letsnomnomblog?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/data/user_profile_pictures/978/a4a436e6256c926bb06bd55cdbbf7978.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A","profile_deeplink":"zomato://u/22892611"},"res_id":16781658,"caption":"","timestamp":1434661134,"friendly_time":"Jun 19, 2015","width":640,"height":640}
                 */

                private PhotoBean photo;

                public PhotoBean getPhoto() {
                    return photo;
                }

                public void setPhoto(PhotoBean photo) {
                    this.photo = photo;
                }

                public static class PhotoBean {
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
    }
}
