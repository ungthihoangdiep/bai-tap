package com.example.myfriend;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name;
    private String status;
    private int avt_fr;

    public Friend(String name, String status, int avt_fr) {

        this.name = name;
        this.status = status;
        this.avt_fr = avt_fr;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getAvt_fr() {
        return avt_fr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvt_fr(int avt_fr) {
        this.avt_fr = avt_fr;
    }
}
