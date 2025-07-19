package com.uitstalie.nutrition.nutrition.loader;

import com.google.gson.*;
import com.uitstalie.nutrition.nutrition.Nutrition;
import com.uitstalie.nutrition.nutrition.data.NutritionGroup;
import com.uitstalie.nutrition.nutrition.util.log.Log;
import net.minecraft.client.multiplayer.chat.report.AbuseReportSender;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Services;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NutritionGroupLoader extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    private final List<NutritionGroup> groups = new ArrayList<>();

    public NutritionGroupLoader(){
        super(GSON,"nutrition/groups");
    }

    private void createGroup(JsonObject object){
        NutritionGroup.Builder builder = NutritionGroup.Builder.create();
        if(object.has("name")){
            builder.name(GsonHelper.getAsString(object,"name"));
        }
        if(object.has("icon")){
            builder.icon(GsonHelper.getAsString(object,"icon"));
        }
        if(object.has("color")){
            builder.color(GsonHelper.getAsString(object,"color"));
        }
        groups.add(builder.build());
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceLocationJsonElementMap, ResourceManager resourceManager, ProfilerFiller profilerFiller) {

        for(Map.Entry<ResourceLocation,JsonElement> entry:resourceLocationJsonElementMap.entrySet()){
            ResourceLocation location = entry.getKey();
            if(location.getNamespace().equals(Nutrition.MODID)){
                try{
                    //这里有一个防呆设计，但是我不是很喜欢捏
                    createGroup(GsonHelper.convertToJsonObject(entry.getValue(),"top element"));
                } catch (IllegalArgumentException | JsonParseException e){
                    Log.d("NutritionGroupLoader","parsing error when loading group:"+location+"e:"+e);
                }
            }
            Log.d("NutritionGroupLoader",groups.toString());
        }
    }
}
