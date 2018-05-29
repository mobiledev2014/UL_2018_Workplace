package com.unilab.workplace.retrofit.postsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by c_jsbustamante on 8/4/2016.
 */
public class ModelSamp {


    @SerializedName("branch_code")
    @Expose
    private String branchCode;
    @SerializedName("account_code")
    @Expose
    private String accountCode;
    @SerializedName("territory_code")
    @Expose
    private String territoryCode;
    @SerializedName("team_code")
    @Expose
    private String teamCode;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("update_time")
    @Expose
    private String updateTime;
    @SerializedName("branch_lat_lng")
    @Expose
    private String branchLatLng;
    @SerializedName("address_unit_no")
    @Expose
    private String addressUnitNo;
    @SerializedName("address_bldg_no")
    @Expose
    private String addressBldgNo;
    @SerializedName("address_street_no")
    @Expose
    private String addressStreetNo;
    @SerializedName("address_barangay")
    @Expose
    private String addressBarangay;
    @SerializedName("address_city")
    @Expose
    private String addressCity;
    @SerializedName("address_zip_code")
    @Expose
    private String addressZipCode;
    @SerializedName("address_province")
    @Expose
    private String addressProvince;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("account_name")
    @Expose
    private String accountName;

    /**
     * @return The branchCode
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode The branch_code
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * @return The accountCode
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * @param accountCode The account_code
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * @return The territoryCode
     */
    public String getTerritoryCode() {
        return territoryCode;
    }

    /**
     * @param territoryCode The territory_code
     */
    public void setTerritoryCode(String territoryCode) {
        this.territoryCode = territoryCode;
    }

    /**
     * @return The teamCode
     */
    public String getTeamCode() {
        return teamCode;
    }

    /**
     * @param teamCode The team_code
     */
    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    /**
     * @return The branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName The branch_name
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return The isActive
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * @param isActive The is_active
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * @return The updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime The update_time
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return The branchLatLng
     */
    public String getBranchLatLng() {
        return branchLatLng;
    }

    /**
     * @param branchLatLng The branch_lat_lng
     */
    public void setBranchLatLng(String branchLatLng) {
        this.branchLatLng = branchLatLng;
    }

    /**
     * @return The addressUnitNo
     */
    public String getAddressUnitNo() {
        return addressUnitNo;
    }

    /**
     * @param addressUnitNo The address_unit_no
     */
    public void setAddressUnitNo(String addressUnitNo) {
        this.addressUnitNo = addressUnitNo;
    }

    /**
     * @return The addressBldgNo
     */
    public String getAddressBldgNo() {
        return addressBldgNo;
    }

    /**
     * @param addressBldgNo The address_bldg_no
     */
    public void setAddressBldgNo(String addressBldgNo) {
        this.addressBldgNo = addressBldgNo;
    }

    /**
     * @return The addressStreetNo
     */
    public String getAddressStreetNo() {
        return addressStreetNo;
    }

    /**
     * @param addressStreetNo The address_street_no
     */
    public void setAddressStreetNo(String addressStreetNo) {
        this.addressStreetNo = addressStreetNo;
    }

    /**
     * @return The addressBarangay
     */
    public String getAddressBarangay() {
        return addressBarangay;
    }

    /**
     * @param addressBarangay The address_barangay
     */
    public void setAddressBarangay(String addressBarangay) {
        this.addressBarangay = addressBarangay;
    }

    /**
     * @return The addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * @param addressCity The address_city
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * @return The addressZipCode
     */
    public String getAddressZipCode() {
        return addressZipCode;
    }

    /**
     * @param addressZipCode The address_zip_code
     */
    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    /**
     * @return The addressProvince
     */
    public String getAddressProvince() {
        return addressProvince;
    }

    /**
     * @param addressProvince The address_province
     */
    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    /**
     * @return The zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode The zip_code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

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
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName The account_name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
