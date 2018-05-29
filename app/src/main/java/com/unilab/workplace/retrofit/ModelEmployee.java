package com.unilab.workplace.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by c_jsbustamante on 8/3/2016.
 */
public class ModelEmployee {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("salary_grade")
    @Expose
    private String salaryGrade;
    @SerializedName("terr")
    @Expose
    private String terr;
    @SerializedName("competency")
    @Expose
    private String competency;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The salaryGrade
     */
    public String getSalaryGrade() {
        return salaryGrade;
    }

    /**
     * @param salaryGrade The salary_grade
     */
    public void setSalaryGrade(String salaryGrade) {
        this.salaryGrade = salaryGrade;
    }

    /**
     * @return The terr
     */
    public String getTerr() {
        return terr;
    }

    /**
     * @param terr The terr
     */
    public void setTerr(String terr) {
        this.terr = terr;
    }

    /**
     * @return The competency
     */
    public String getCompetency() {
        return competency;
    }

    /**
     * @param competency The competency
     */
    public void setCompetency(String competency) {
        this.competency = competency;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The doctorName
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName The doctor_name
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
