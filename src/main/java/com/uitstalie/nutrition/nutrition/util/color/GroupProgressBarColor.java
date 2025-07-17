package com.uitstalie.nutrition.nutrition.util.color;

public class GroupProgressBarColor {
    int a;
    int r;
    int g;
    int b;

    public GroupProgressBarColor(int a,int r,int g,int b){
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public GroupProgressBarColor(int r,int g,int b){
        this.a = 255;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
