package com.example.user.schooltrackerdriver.Retrofit;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by USER on 01-02-2018.
 */

public interface API {

    @FormUrlEncoded
    @POST("/sample/school_app/api/vehicles_api.php")
    Call<JsonElement>login(@Field("action") String action, @Field("user_name") String user_name, @Field("password") String password);

    @FormUrlEncoded
    @POST("/sample/school_app/api/vehicles_api.php")
    Call<JsonElement>getProfile(@Field("action") String action, @Field("user_id") int userId);

}
