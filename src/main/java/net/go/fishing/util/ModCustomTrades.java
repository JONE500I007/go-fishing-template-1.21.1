package net.go.fishing.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.go.fishing.GoFishing;
import net.go.fishing.item.ModItems;
import net.go.fishing.villager.ModVillagers;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        GoFishing.LOGGER.info("Registering Villager Trades From " + GoFishing.MOD_ID);
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(Items.WHEAT, 10),
                    10, 2, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 9),
                    new ItemStack(Items.EMERALD, 2),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 7),
                    new ItemStack(Items.DIAMOND, 1),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.GOLD_INGOT, 5),
                    new ItemStack(ModItems.COOKED_BLUE_FISH, 1),
                    10, 15, 0.1f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.FISHING_MASTER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(Items.WHEAT, 10),
                    10, 2, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 9),
                    new ItemStack(Items.EMERALD, 2),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 7),
                    new ItemStack(Items.DIAMOND, 1),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.GOLD_INGOT, 5),
                    new ItemStack(ModItems.COOKED_BLUE_FISH, 1),
                    10, 15, 0.1f
            ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FISHING_MASTER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(Items.COAL_BLOCK, 10),
                    10, 2, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 9),
                    new ItemStack(Items.DIAMOND, 2),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FISHING_COIN, 7),
                    new ItemStack(Items.DIAMOND, 1),
                    16, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.GOLD_INGOT, 5),
                    new ItemStack(ModItems.FISHING_COIN, 1),
                    10, 15, 0.1f
            ));
        });
    }
}
