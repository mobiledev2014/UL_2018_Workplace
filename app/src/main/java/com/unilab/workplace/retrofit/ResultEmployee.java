package com.unilab.workplace.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c_jsbustamante on 8/3/2016.
 */
public class ResultEmployee {

    @SerializedName("result")
    @Expose
    private List<ModelEmployee> result = new ArrayList<ModelEmployee>();

    /**
     * @return The result
     */
    public List<ModelEmployee> getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(List<ModelEmployee> result) {
        this.result = result;
    }
}
