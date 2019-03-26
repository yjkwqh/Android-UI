package com.example.ui;

public class Animals {
    private String name;
    private int imagesId;

    public Animals(String name,int Id){
        this.name = name;
        this.imagesId = Id;
    }

    public String getName(){
        return name;
    }

    public int getImagesId(){
        return imagesId;
    }
}


