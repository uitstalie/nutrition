package com.uitstalie.nutrition.nutrition.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public class NutritionFoodDataMixin {
    private Player player;

    @Inject(at = @At("TAIL"),method = "eat(IF)V")
    public void nutrition$eat(int healing, float saturation, CallbackInfo ci){

    }
}
