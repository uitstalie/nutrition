package com.uitstalie.nutrition.nutrition.client;

import com.uitstalie.nutrition.nutrition.Nutrition;
import com.uitstalie.nutrition.nutrition.util.log.Log;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

/**
 * use this as the general client event listener
 */
@EventBusSubscriber(modid = Nutrition.MODID, value = Dist.CLIENT)
public class NutritionClientEventListener {
    public NutritionClientEventListener() {

        NeoForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void OnClientSetup(FMLClientSetupEvent event) {
        Log.d("NutritionClientEventListener", "onClientSetup");
    }

}
