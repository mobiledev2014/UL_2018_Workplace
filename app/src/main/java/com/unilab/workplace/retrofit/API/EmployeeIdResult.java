package com.unilab.workplace.retrofit.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by c_alraygon on 1/17/2017.
 */
public class EmployeeIdResult {
    @SerializedName("data")
    @Expose
    private List<EmployeeIdModel> data = null;

    public List<EmployeeIdModel> getData() {
        return data;
    }

    public void setData(List<EmployeeIdModel> data) {

        this.data = data;

    }

}