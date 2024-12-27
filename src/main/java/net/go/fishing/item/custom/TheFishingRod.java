package net.go.fishing.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.go.fishing.GoFishing;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class TheFishingRod extends FishingRodItem {
    public TheFishingRod(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return super.finishUsing(stack, world, user);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack);
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        return enchantment.matchesKey(Enchantments.LUCK_OF_THE_SEA)
                || enchantment.matchesKey(Enchantments.LURE)
                || enchantment.matchesKey(Enchantments.MENDING)
                || enchantment.matchesKey(Enchantments.UNBREAKING)
                || enchantment.matchesKey(Enchantments.VANISHING_CURSE);
    }

    /*
    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        var registry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
        var mendingEntry = registry.entryOf(Enchantments.MENDING);
        stack.addEnchantment(mendingEntry, 1);
    }
     */
    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        var registry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
        var mendingEntry = registry.getEntry(Enchantments.MENDING);
        if (mendingEntry.isPresent()) {
            stack.addEnchantment(mendingEntry.get(), 10);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        var registry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
        var mendingEntry = registry.getEntry(Enchantments.MENDING);
        if (!stack.hasEnchantments() && mendingEntry.isPresent()) {
            stack.addEnchantment(mendingEntry.get(), 10);
        }
    }

    @Override
    public int getEnchantability() {
        return 3;
    }
}
