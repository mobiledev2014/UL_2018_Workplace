package com.unilab.workplace.retrofit.post;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by c_jsbustamante o8/4/2016.
 */
public interface PostInterFaceApi {
//get

    @POST("ojl/loginuser.php")
    Call<ResultPostEmployee> postPSR();


    // post
    @FormUrlEncoded
        @POST("ojl/loginuser.php/")
    Call<ResultPostEmployee> getUser(@Field("username") String username, @Field("password") String password);
}
