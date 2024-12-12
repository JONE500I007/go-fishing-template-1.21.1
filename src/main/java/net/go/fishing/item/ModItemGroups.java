package net.go.fishing.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.go.fishing.GoFishing;
import net.go.fishing.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.go.fishing.item.ModItems.*;

public class ModItemGroups {
    public static final ItemGroup RAW_GREEDILY_FISH_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GoFishing.MOD_ID, "raw_greedily_fish_item"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(RAW_GREEDILY_FISH))
                    .displayName(Text.translatable("itemgroup.go-fishing.raw_greedily_fish_item"))
                    .entries((displayContext, entries) -> {
                        entries.add(FISHING_COIN);
                        entries.add(PEARL);
                        entries.add(RAW_BLUE_FISH);
                        entries.add(COOKED_BLUE_FISH);
                        entries.add(RAW_GREEDILY_FISH);
                        entries.add(BLACK_CARD_FISH);
                        entries.add(BURNED_BLACK_CARD_FISH);
                        entries.add(RED_CARD_FISH);
                        entries.add(BURNED_RED_CARD_FISH);

                        entries.add(BAMBOO_FISHING_ROD);

                        entries.add(ModBlocks.COMPRESSED_FISH_BLOCK);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        GoFishing.LOGGER.info("Registering Item Groups for " + GoFishing.MOD_ID);
    }
}
