
package com.example.salarysystem.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PersonModel {

    @SerializedName("birth_place")
    private String birthPlace;
    @SerializedName("city_name")
    private String cityName;
    @Expose
    private String degree;
    @Expose
    private String departman;
    @Expose
    private String fstatus;
    @Expose
    private String id;
    @SerializedName("job_status")
    private String jobStatus;
    @Expose
    private String lname;
    @Expose
    private String name;
    @SerializedName("national_code")
    private String nationalCode;
    @SerializedName("persnality_code")
    private String persnalityCode;
    @Expose
    private Object role;
    @SerializedName("since_com")
    private Object sinceCom;

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPersnalityCode() {
        return persnalityCode;
    }

    public void setPersnalityCode(String persnalityCode) {
        this.persnalityCode = persnalityCode;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public Object getSinceCom() {
        return sinceCom;
    }

    public void setSinceCom(Object sinceCom) {
        this.sinceCom = sinceCom;
    }

}
