package com.uitstalie.nutrition.nutrition.util.log;


import com.uitstalie.nutrition.nutrition.Nutrition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static Logger LOG = LoggerFactory.getLogger(Nutrition.MODID);
    private static String PREFIX = "Nutrition_";
    public static void d(String tag,String message){
        LOG.debug("{}:{}",PREFIX+tag,message);
    }
    public static void e(String tag,String message){
        LOG.error("{}:{}",PREFIX+tag,message);
    }
}

