package com.uitstalie.nutrition.nutrition.mixin.client;

import com.uitstalie.nutrition.nutrition.api.mixin.PlayerInterface;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class NutritionPlayerMixin {

    @Shadow
    protected FoodData foodData;

    @Inject(at = @At("RETURN"),method = "<init>*")
    public void nutrition$init(CallbackInfo ci){
        ((PlayerInterface)foodData).setPlayer(((Player)(Object)this));
    }
}
