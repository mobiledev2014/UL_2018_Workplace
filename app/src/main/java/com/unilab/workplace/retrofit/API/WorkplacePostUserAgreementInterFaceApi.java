package com.unilab.workplace.retrofit.API;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by c_jsbustamante o8/4/2016.
 */
public interface WorkplacePostUserAgreementInterFaceApi {
//get

//    @POST("workplace/GetUserAgreement.php")
//    Call<EmployeeIdResult> postAgreement();


    // post
    @FormUrlEncoded
    @POST("GetUserAgreement.php/")
    Call<EmployeeIdResult> postAgreement(@Field("emp_id") String emp_id,@Field("emp_agreement") String emp_agreement);


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

