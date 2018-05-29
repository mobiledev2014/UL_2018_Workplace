package com.unilab.workplace.retrofit.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c_jsbustamante on 8/4/2016.
 */
public class ResultPostEmployee {

    @SerializedName("result")
    @Expose
    private List<ModelPostEmployee> result = new ArrayList<ModelPostEmployee>();

    /**
     * @return The result
     */
    public List<ModelPostEmployee> getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(List<ModelPostEmployee> result) {
        this.result = result;
    }
}
