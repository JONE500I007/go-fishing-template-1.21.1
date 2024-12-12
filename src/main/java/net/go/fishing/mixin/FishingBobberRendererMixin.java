package net.go.fishing.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.go.fishing.item.ModItems;
import net.minecraft.client.render.entity.FishingBobberEntityRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingBobberEntityRenderer.class)
public abstract class FishingBobberRendererMixin {
    @ModifyExpressionValue(method = "getHandPos",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean addCustomFishingRodToFishingRodCheck(boolean original, @Local ItemStack itemStack) {
        return original || itemStack.isOf(ModItems.BAMBOO_FISHING_ROD);
    }
}
