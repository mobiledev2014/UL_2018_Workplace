package com.unilab.workplace.retrofit.API;

/**
 * Created by c_alraygon on 1/17/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeIdModel {

    @SerializedName("emp_id")
    @Expose
    private String empId;
    @SerializedName("emp_birthdate")
    @Expose
    private String empBirthdate;
    @SerializedName("emp_status")
    @Expose
    private String empStatus;
    @SerializedName("emp_agreement")
    @Expose
    private String empAgreement;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpBirthdate() {
        return empBirthdate;
    }

    public void setEmpBirthdate(String empBirthdate) {
        this.empBirthdate = empBirthdate;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getEmpAgreement() {
        return empAgreement;
    }

    public void setEmpAgreement(String empAgreement) {
        this.empAgreement = empAgreement;
    }

    @Override
    public String toString() {
        return "EmployeeIdModel{" +
                "empId='" + empId + '\'' +
                ", empBirthdate='" + empBirthdate + '\'' +
                ", empStatus='" + empStatus + '\'' +
                ", empAgreement='" + empAgreement + '\'' +
                '}';
    }
}