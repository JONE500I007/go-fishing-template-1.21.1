package net.go.fishing.mixin;

import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(VillagerData.class)
public class VillagerDataMixin {
    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 10, ordinal = 0))
    private static int modifyLevel1Experience(int original) {
        return 99999;
    }
}
