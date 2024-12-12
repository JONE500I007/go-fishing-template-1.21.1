package net.go.fishing.mixin.override_cap;

import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import static net.go.fishing.GoFishing.MAX_STACK_SIZE_CAP;

@Mixin(Inventory.class)
public interface InventoryMixin {
    @ModifyConstant( method = "getMaxCountPerStack", constant = @Constant(intValue = 99))
    private int changeMaxStackSizeLimit(int original) {
        return MAX_STACK_SIZE_CAP;
    }
}
