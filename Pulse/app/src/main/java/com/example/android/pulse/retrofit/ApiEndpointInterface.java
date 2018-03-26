package com.example.android.pulse.retrofit;


import com.example.android.pulse.Beans.GetMessageListBean.GetGroupMembersList;
import com.example.android.pulse.Beans.GetMessageListBean.GetMessageList;
import com.example.android.pulse.Beans.LoginBean.GetLoginDetailsBean;
import com.example.android.pulse.Beans.PlacesBean.GetAddPlaces;
import com.example.android.pulse.Beans.PlacesBean.GetPlacesDetailsBean;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiEndpointInterface {

/*	@GET("/categories?locale=en")
    void getShopCat( Callback<ShopApiBean> cb);*/
    /*@FormUrlEncoded
    @POST("/api/categories")
    void getCategories(@Field("code") String code, Callback<CategoriesBean> cb);

    @FormUrlEncoded
    @POST("/api/search")
    void getProducts(@Field("categories_id") int categories_id, @Field("search_item") String search_item, @Field("page") int pages, Callback<ProductBeans> cb);
*/

    @GET("/")
    void getUserData(@Query("case") String case1, @Query("username") String username, @Query("password") String password, @Query("device_type") String device_type, @Query("device_token") String device_token, @Query("user_latitude") String user_latitude, @Query("user_longitude") String user_longitude, @Query("user_radius") String user_radius, Callback<GetLoginDetailsBean> cb);
//    @GET("/user_data")
//    void getUserData(@Query("username") String username, @Query("emp_id") String emp_id, @Query("key_id") String key_id, @Query("imei_number") String imei_number, @Query("model_number") String model_number,@Query("device_token") String device_token,@Query("login_type") String login_type, @Query("latitude") String latitude, @Query("longitude") String longitude, @Query("is_safe") String is_safe, Callback<LogoutDayoffBean> cb);
    @GET("/")
void getPlacesList(@Query(value = "case", encodeName = true) String case1,@Query("group_id") String group_id,Callback<GetPlacesDetailsBean> cb);

    @GET("/")
    void getAddPlaces(@Query("case") String case1,@Query("user_id") String user_id,@Query("user_latitude") String user_latitude,@Query("user_longitude") String user_longitude,@Query("user_radius") String user_radius,@Query("place_name") String place_name,@Query("place_address") String place_address,@Query("group_id") String group_id,Callback<GetAddPlaces> cb);
    @GET("/")
    void getMessages(@Query("case") String case1,@Query("user_id") String user_id,Callback<GetMessageList> cb);

    @GET("/")
    void getGroupMembers(@Query("case") String case1,@Query("group_id") String group_id,Callback<GetGroupMembersList> cb);
}
