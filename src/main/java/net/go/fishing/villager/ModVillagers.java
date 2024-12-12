package net.go.fishing.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.go.fishing.GoFishing;
import net.go.fishing.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> FISHING_POI_KEY = poiKey("fishingpoi");
    public static final PointOfInterestType FISHING_POI = registerPoi("fishingpoi", ModBlocks.COMPRESSED_FISH_BLOCK);

    public static final VillagerProfession FISHING_MASTER = registerProfession("fishing_master", FISHING_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(GoFishing.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(GoFishing.MOD_ID, name),1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(GoFishing.MOD_ID, name));
    }

    public static void registerVillagers() {
        GoFishing.LOGGER.info("Registering Villagers" + GoFishing.MOD_ID);
    }
}
