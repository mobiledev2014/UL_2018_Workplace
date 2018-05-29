package com.unilab.workplace.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c_jsbustamante on 8/3/2016.
 */
public interface InterFaceApi {


    //Call the result employee
    @GET("ojl/getPSR.php")
    Call<ResultEmployee> getPSR();


}
