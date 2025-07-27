package com.uitstalie.nutrition.nutrition.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public class NutritionPlayerMixin {
    @Shadow
    protected FoodData foodData;
}
