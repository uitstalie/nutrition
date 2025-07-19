package com.uitstalie.nutrition.nutrition.data;

import org.checkerframework.checker.units.qual.N;

public class NutritionGroup {
    private String groupName;
    private String groupIcon;
    private String groupProgressBarColor;

















    public static class Builder{
        private NutritionGroup inner;

        public Builder(){
            inner = new NutritionGroup();
        }
        private void clean(){
            inner = new NutritionGroup();
        }
        public static Builder INSTANCE = new Builder();

        public static Builder create() {
            INSTANCE.clean();
            return INSTANCE;
        }

        public Builder name(String name){
            this.inner.groupName = name;
            return this;
        }
        public Builder icon(String icon){
            this.inner.groupIcon = icon;
            return this;
        }
        public Builder color(String color){
            this.inner.groupProgressBarColor = color;
            return this;
        }
        public NutritionGroup build(){
            return inner;
        }
    }
}

