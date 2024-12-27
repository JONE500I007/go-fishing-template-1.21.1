package net.go.fishing.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin2 {
    @ModifyExpressionValue(method = "canLevelUp", at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerData;getUpperLevelExperience(I)I"))
    private int changeUpperLevelXp(int original) {
        if (original != 10) return original;
        VillagerEntity villager = (VillagerEntity) (Object) this;
        VillagerData villagerData = villager.getVillagerData();
        if (villagerData.getProfession() != VillagerProfession.FARMER) return original;
        return 100;
    }
}
