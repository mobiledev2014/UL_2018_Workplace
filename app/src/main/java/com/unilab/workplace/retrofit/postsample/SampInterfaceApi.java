package com.unilab.workplace.retrofit.postsample;

import com.unilab.workplace.retrofit.post.ResultPostEmployee;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by c_jsbustamante on 8/4/2016.
 */
public interface SampInterfaceApi {

    @POST("api/workplan/getBranchAccount")
    Call<ResultPostEmployee> getBranchAccount();


    // body request
    @FormUrlEncoded
    @POST("api/workplan/getBranchAccount/")
    Call<ResultSamp> getBranchAccount(@Field("user_id") String user_id, @Field("imei") String imei, @Field("key") String key, @Field("status") String status, @Field("account_exclusive") String account_exclusive);
}
