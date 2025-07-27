package com.uitstalie.nutrition.nutrition.data.group.Manager;

import com.uitstalie.nutrition.nutrition.data.group.NutritionGroup;

import java.util.HashMap;
import java.util.Map;

public class NutritionGroupManager {
    public Map<String, NutritionGroup> manager;
    public NutritionGroupManager(){
        manager = new HashMap<>();
    }
    public void reload(){

    }
    public int insert(String name,NutritionGroup group){
        if(!manager.containsKey(name)){
            manager.put(name,group);
        }
        else{

        }
    }
    public void get(){

    }
    public void getAll(){

    }
}
