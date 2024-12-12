package net.go.fishing.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.go.fishing.GoFishing;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COMPRESSED_FISH_BLOCK = registerBlock("compressed_fish_block",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.HONEY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GoFishing.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GoFishing.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        GoFishing.LOGGER.info("Registering Mod Blocks for " + GoFishing.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.COMPRESSED_FISH_BLOCK);
        });
    }
}
