package com.uitstalie.nutrition.nutrition.util.color;

import org.checkerframework.checker.units.qual.C;

import java.util.regex.Pattern;

public class Color {
    int a = -1;
    int r = -1;
    int g = -1;
    int b = -1;

    private Color() {
    }



    public static class ColorBuilder{
        private final Color inner;
        private int valueCheck;
        private ColorBuilder(){
            inner = new Color();
        }

        public static ColorBuilder create(){
            return new ColorBuilder();
        }

        public ColorBuilder a(int a){
            inner.a = a;
            return this;
        }
        public ColorBuilder r(int r){
            inner.r = r;
            return this;
        }
        public ColorBuilder g(int g){
            inner.g = g;
            return this;
        }
        public ColorBuilder b(int b){
            inner.b = b;
            return this;
        }
        public Color build(){
            if(inner.a == -1 || inner.r == -1 || inner.g == -1 || inner.b == -1){
                throw new IllegalArgumentException("Invalid Color");
            }
            return inner;
        }
    }

    public static Color GERY = ColorBuilder.create().a(255).r(192).g(192).b(192).build();




    /**
     * format argb(float|int,int,int,int)
     */
    private static final Pattern ARGB_STRING_PATTERN = Pattern.compile("^[Aa][Rr][Gg][Bb]\\((0|([1-9][0-9]*))(\\.\\d+)?,(0|[1-9][0-9]*),(0|[1-9][0-9]*),(0|[1-9][0-9]*)\\)$");
    private static Color covertARGBStringPattern(String inputARGBString){
        String cutArrange = inputARGBString.substring(5, inputARGBString.length() - 1);
        String[] split = cutArrange.split(",");
        ColorBuilder builder = ColorBuilder.create();
        if(split[0].contains(".")){//float numer between [0,1] will be tran to int{0,...,255}
            builder.a((int) (Double.parseDouble(split[0])*255));
        }
        else{
        builder.a(Integer.parseInt(split[0]));
        }
        builder.r(Integer.parseInt(split[1]));
        builder.g(Integer.parseInt(split[2]));
        builder.b(Integer.parseInt(split[3]));
        return builder.build();
    }

    /**
     * format rgb(int,int,int)
     */
    private static final Pattern RGB_STRING_PATTERN = Pattern.compile("^[Rr][Gg][Bb]\\((0|[1-9][0-9]*),(0|[1-9][0-9]*),(0|[1-9][0-9]*)\\)$");
    private static Color covertRGBStringPattern(String inputRGBString){
        String cutArrange = inputRGBString.substring(4, inputRGBString.length() - 1);
        String[] split = cutArrange.split(",");
        ColorBuilder builder = ColorBuilder.create();
        builder.a(255);
        builder.r(Integer.parseInt(split[0]));
        builder.g(Integer.parseInt(split[1]));
        builder.b(Integer.parseInt(split[2]));
        return builder.build();
    }

    /**
     * format rgba(int,int,int,int|float)
     */
    private static final Pattern RGBA_STRING_PATTERN = Pattern.compile("^[Rr][Gg][Bb][Aa]\\((0|[1-9][0-9]*),(0|[1-9][0-9]*),(0|[1-9][0-9]*),(0|([1-9][0-9]*))(\\.\\d+)?\\)$");
    private static Color covertRGBAStringPattern(String inputRGBAString){
        String cutArrange = inputRGBAString.substring(5, inputRGBAString.length() - 1);
        String[] split = cutArrange.split(",");
        ColorBuilder builder = ColorBuilder.create();
        if(split[3].contains(".")){//float numer between [0,1] will be tran to int{0,...,255}
            builder.a((int) (Double.parseDouble(split[3])*255));
        }
        else{
            builder.a(Integer.parseInt(split[3]));
        }
        builder.r(Integer.parseInt(split[0]));
        builder.g(Integer.parseInt(split[1]));
        builder.b(Integer.parseInt(split[2]));
        return builder.build();
    }

    /**
     * format #RRGGBB
     */
    private static final Pattern RGB_HEX_PATTERN = Pattern.compile("^#([0-9a-fA-F]{6})$");
    private static Color covertRGBHexStringPattern(String inputRGBHexString){
        String r = inputRGBHexString.substring(1,3);
        String g = inputRGBHexString.substring(3,5);
        String b = inputRGBHexString.substring(5,7);
        ColorBuilder builder = ColorBuilder.create();
        builder.r(Integer.parseInt(r));
        builder.g(Integer.parseInt(g));
        builder.b(Integer.parseInt(b));
        builder.a(255);
        return builder.build();
    }

    public static Color covertColorFromString(String inputColor){
        if(RGBA_STRING_PATTERN.matcher(inputColor).matches()){
            return covertRGBAStringPattern(inputColor);
        }
        else if(RGB_STRING_PATTERN.matcher(inputColor).matches()){
            return covertRGBStringPattern(inputColor);
        }
        else if(ARGB_STRING_PATTERN.matcher(inputColor).matches()){
            return covertARGBStringPattern(inputColor);
        }
        else if(RGB_HEX_PATTERN.matcher(inputColor).matches()){
            return covertRGBHexStringPattern(inputColor);
        }
        else{
            throw new IllegalArgumentException("Invalid Color");
        }
    }
}
