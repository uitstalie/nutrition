package com.uitstalie.nutrition.nutrition.mixin.server;

import com.uitstalie.nutrition.nutrition.api.mixin.PlayerInterface;
import com.uitstalie.nutrition.nutrition.util.log.Log;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public class NutritionFoodDataMixin implements PlayerInterface {
    @Unique
    private Player nutrition$player;

    @Inject(at = @At("TAIL"),method = "eat(IF)V")
    public void nutrition$eat(int foodLevel, float saturationLevel, CallbackInfo ci){
        nutrition$player.sendSystemMessage(Component.literal("uitstalie:"+nutrition$player.getStringUUID()));
        Log.d("Nutrition","Nutrition eat1");
    }

    @Inject(at = @At("TAIL"),method = "eat(Lnet/minecraft/world/food/FoodProperties;)V")
    public void nutrition$eat(FoodProperties properties, CallbackInfo ci){
        nutrition$player.sendSystemMessage(Component.literal("uitstalie:"+nutrition$player.getStringUUID()));
        Log.d("Nutrition","Nutrition eat2");
    }

    @Override
    public void setPlayer(Player player){
        this.nutrition$player = player;
        Log.d("Nutrition","Nutrition eat");
    }
    @Override
    public Player getPlayer(){
        return this.nutrition$player;

    }
}
