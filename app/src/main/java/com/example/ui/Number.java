package com.example.ui;

public class Number {
    private String name;
    private int imageId;
    public Number(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
