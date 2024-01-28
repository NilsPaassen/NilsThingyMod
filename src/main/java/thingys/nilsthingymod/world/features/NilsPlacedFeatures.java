package thingys.nilsthingymod.world.features;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;

import java.util.ArrayList;
import java.util.List;

public class NilsPlacedFeatures {
    static final BlockPredicate ON_DIRT = BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT);

    public static final RegistryKey<PlacedFeature> POPLAR_PLACED_KEY = registerKey("poplar_placed");


    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
            entries.add(
                    POPLAR_PLACED_KEY,
                    placeTreeFeature(entries,
                            1, BlockPredicate.wouldSurvive(NilsBlocks.POPLAR_SAPLING.getDefaultState(),Direction.DOWN.getVector()), NilsConfiguredFeatures.POPLAR_KEY)
            );


               /* */
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NilsThingyMod.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static PlacedFeature placeTreeFeature(FabricDynamicRegistryProvider.Entries entries, int count, BlockPredicate predicate, RegistryKey<ConfiguredFeature<?, ?>> feature) {
        return placeFeature(entries, feature,
                PlacedFeatures.createCountExtraModifier(count, 0.1f, 1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(predicate));
    }

    public static PlacedFeature placeTreeFeature(FabricDynamicRegistryProvider.Entries entries, int count, int maxWaterDepth, BlockPredicate predicate, RegistryKey<ConfiguredFeature<?, ?>> feature) {
        return placeFeature(entries, feature,
                PlacedFeatures.createCountExtraModifier(count, 0.1f, 1),
                SquarePlacementModifier.of(),
                PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
                SurfaceWaterDepthFilterPlacementModifier.of(maxWaterDepth),
                BlockFilterPlacementModifier.of(predicate));
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return placeFeature(entries, feature, list);
    }

    private static PlacedFeature placeFeatureWithoutBiomeFilter(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        return placeFeature(entries, feature, list);
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
        return new PlacedFeature(entries.ref(feature), list);
    }

    public static void init(){}
}
