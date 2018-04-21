package com.example.mohammed.graduationproject.model;

/**
 * Created by abdallah on 4/21/18.
 */

public class User {
    private String name ;
    private String email ;
    private String mobileNumber ;
    private String adress ;
    private String job;
    private String password ;
    private String isAdmin ;

    public User() {
    }

    public User(String name, String email, String mobileNumber, String adress, String job, String password, String isAdmin) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.adress = adress;
        this.job = job;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String isAdmin() {
        return isAdmin;
    }

    public void setAdmin(String admin) {
        isAdmin = admin;
    }
}

