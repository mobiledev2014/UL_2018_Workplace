package com.unilab.workplace.retrofit.API;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.unilab.workplace.retrofit.post.ModelPostEmployee;
import com.unilab.workplace.retrofit.post.ResultPostEmployee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by c_jsbustamante o8/4/2016.
 */
public interface WorkplacePostInterFaceApi {
//get
//
//    @POST("workplace/GetUserData.php")
//    Call<EmployeeIdResult> postEmp();


    // post
//    @FormUrlEncoded
//    @POST("workplace/GetUserData.php/")
//    Call<EmployeeIdResult> postUser(@Field("emp_id") String emp_id);

    // post
    @FormUrlEncoded
    @POST("GetUserData.php/")
    Call<EmployeeIdResult> postUser(@Field("emp_id") String emp_id);


    //post

//
//    @SerializedName("result")
//    @Expose
//    private List<ModelPostEmployee> result = new ArrayList<ModelPostEmployee>();
//
//    /**
//     * @return The result
//     */
//    public List<ModelPostEmployee> getResult() {
//        return result;
//    }
//
//    /**
//     * @param result The result
//     */
//    public void setResult(List<ModelPostEmployee> result) {
//        this.result = result;
//    }

}

