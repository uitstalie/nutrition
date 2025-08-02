package com.uitstalie.nutrition.nutrition.mixin.client;

import com.uitstalie.nutrition.nutrition.api.mixin.PlayerInterface;
import com.uitstalie.nutrition.nutrition.util.log.Log;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(FoodData.class)
public abstract class NutritionFoodDataMixin implements PlayerInterface {

    /**
     * 游戏中存在ClientPlayer和ServerPlayer两种Player
     * 其中ClientPlayer主要负责渲染和某些数据的临时同步
     * 真正的数据同步是ServerPlayer在进行，因此我们此处也要区分两种Player
     * 此处我根据optional的特点转杯尝试使用某种方式在java中实现kotlin的语法糖？（有点太糖了吧）
     */
    @Unique
    private Player nutrition$ServerPlayer ;
    @Unique
    private Player nutrition$ClientPlayer ;

    @Inject(at = @At("TAIL"),method = "eat(IF)V")
    public void nutrition$eat(int foodLevel, float saturationLevel, CallbackInfo ci){
        Log.d("Nutrition","Nutrition eat1");
    }

    @Inject(at = @At("TAIL"),method = "eat(Lnet/minecraft/world/food/FoodProperties;)V")
    public void nutrition$eat(FoodProperties properties, CallbackInfo ci){
        Log.d("Nutrition","Nutrition eat2");
    }

    @Override
    public void setPlayer(Player player){
        if(player instanceof AbstractClientPlayer){
            Log.d("Nutrition","Nutrition eat client");
            nutrition$ClientPlayer = player;
        }
        else if(player instanceof ServerPlayer){
            Log.d("Nutrition","Nutrition eat server");
        }
        else{
            Log.d("Nutrition","Nutrition eat failed");
        }
    }
    @Override
    public Player getPlayer(){
        return null;
    }
}
