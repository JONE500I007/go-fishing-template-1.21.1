package net.go.fishing.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Mixin(VillagerData.class)
public abstract class VillagerExpDataMixin {
    /*
    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 10, ordinal = 0))
    private static int modifyLevel1Experience(int original) {
        return 50;
    }

     */
}
