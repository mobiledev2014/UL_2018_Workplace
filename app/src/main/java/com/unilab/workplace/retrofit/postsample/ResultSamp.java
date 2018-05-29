package com.unilab.workplace.retrofit.postsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c_jsbustamante on 8/4/2016.
 */
public class ResultSamp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("branch_accounts")
    @Expose
    private List<ModelSamp> branchAccounts = new ArrayList<ModelSamp>();

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The branchAccounts
     */
    public List<ModelSamp> getBranchAccounts() {
        return branchAccounts;
    }

    /**
     * @param branchAccounts The branch_accounts
     */
    public void setBranchAccounts(List<ModelSamp> branchAccounts) {
        this.branchAccounts = branchAccounts;
    }

}
