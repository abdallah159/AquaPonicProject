package com.example.mohammed.graduationproject.model;

/**
 * Created by mohammed on 2/18/18.
 */

public class Notification {
    String alarmTitle;
    String message;
    String time;

    public Notification() {
    }

    public Notification(String alarmTitle, String message, String time) {
        this.alarmTitle = alarmTitle;
        this.message = message;
        this.time = time;
    }

    public String getAlarmTitle() {
        return alarmTitle;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
