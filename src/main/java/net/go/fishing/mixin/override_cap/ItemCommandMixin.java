package net.go.fishing.mixin.override_cap;

import net.minecraft.server.command.ItemCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import static net.go.fishing.GoFishing.MAX_STACK_SIZE_CAP;

@Mixin(ItemCommand.class)
public abstract class ItemCommandMixin {
    @ModifyConstant( method = "register", constant = @Constant(intValue = 99))
    private static int changeMaxStackSizeLimit(int original) {
        return MAX_STACK_SIZE_CAP;
    }
}
