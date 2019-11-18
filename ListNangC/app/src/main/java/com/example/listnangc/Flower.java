package com.example.listnangc;

public class Flower {
    private int img_flower;
    private String name_flower;
    private String describe;

    public Flower(int img_flower, String name_flower, String describe) {
        this.img_flower = img_flower;
        this.name_flower = name_flower;
        this.describe = describe;
    }

    public int getImg_flower() {
        return img_flower;
    }

    public String getName_flower() {
        return name_flower;
    }

    public String getDescribe() {
        return describe;
    }

    public void setImg_flower(int img_flower) {
        this.img_flower = img_flower;
    }

    public void setName_flower(String name_flower) {
        this.name_flower = name_flower;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
