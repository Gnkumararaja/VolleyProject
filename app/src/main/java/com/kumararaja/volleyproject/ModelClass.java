package com.kumararaja.volleyproject;

public class ModelClass {
    String name, imageurl;

    public ModelClass(String name, String imageurl){
        this.name=name;
        this.imageurl=imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
