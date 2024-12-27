package net.go.fishing.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(WanderingTraderEntity.class)
public abstract class WanderingTraderMixin {
    @ModifyConstant(method = "fillRecipes", constant = @Constant(intValue = 5))
    private int changeTradeCount(int original) {
        return 20;
    }
}
