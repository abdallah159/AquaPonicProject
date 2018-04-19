package com.example.mohammed.graduationproject.model;

import java.util.Date;

/**
 * Created by mohammed on 2/17/18.
 */

public class Data {
    private String date;
    private int temp;
    private int ph;
    private int highLevel;

    public Data() {
    }

    public Data(String  date, int temp, int ph, int highLevel) {
        this.date = date;
        this.temp = temp;
        this.ph = ph;
        this.highLevel = highLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }

    public int getHighLevel() {
        return highLevel;
    }

    public void setHighLevel(int highLevel) {
        this.highLevel = highLevel;
    }
}
