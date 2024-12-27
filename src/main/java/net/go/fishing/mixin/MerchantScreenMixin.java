package net.go.fishing.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.village.Merchant;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MerchantScreen.class)
public abstract class MerchantScreenMixin extends HandledScreen<MerchantScreenHandler> {
    private MerchantScreenMixin(MerchantScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @ModifyExpressionValue(method = "drawLevelInfo", at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerData;getLowerLevelExperience(I)I"))
    private int changeLowerLevelXp(int original) {
        return changeXp(original);
    }

    @ModifyExpressionValue(method = "drawLevelInfo", at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerData;getUpperLevelExperience(I)I"))
    private int changeUpperLevelXp(int original) {
        return changeXp(original);
    }

    @Unique
    private int changeXp(int original) {
        if (original != 10) return original;
        Merchant merchant = ((MerchantScreenHandlerAccessor) this.handler).getMerchant();
        if (!(merchant instanceof VillagerEntity villager)) return original;
        VillagerData villagerData = villager.getVillagerData();
        if (villagerData.getProfession() != VillagerProfession.FARMER) return original;
        return 100;
    }
}
