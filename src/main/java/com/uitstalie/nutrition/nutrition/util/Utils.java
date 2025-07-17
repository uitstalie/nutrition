package com.uitstalie.nutrition.nutrition.util;

import com.uitstalie.nutrition.nutrition.util.color.Color;
import com.uitstalie.nutrition.nutrition.util.color.GroupProgressBarColor;
import com.uitstalie.nutrition.nutrition.util.log.Log;

public class Utils {
    /**
     * this is used to cover string color to GroupProgressBarColor
     * @param stringColor as ARGB(a,r,g,b) or argb(a,r,g,b)
     * @return Color
     */
    public static Color covertColorFromArgbString(String stringColor){
        if(!stringColor.startsWith("ARGB") && !stringColor.startsWith("argb")){
            Log.d("color","Invalid color string:"+stringColor+
                    "\n color string should be like:ARGB(a,r,g,b) or argb(a,r,g,b)");
            return Color.GERY;
        }
        else{
            String split = stringColor.substring(3);
            return Color.GERY;
        }

    }
}
