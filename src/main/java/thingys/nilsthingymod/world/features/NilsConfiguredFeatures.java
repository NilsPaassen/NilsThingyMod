package thingys.nilsthingymod.world.features;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;

public class NilsConfiguredFeatures {

    public   static  final  RegistryKey<ConfiguredFeature<?,?>> POPLAR_KEY = registerKey("poplar");




    public static void populate(FabricDynamicRegistryProvider.Entries entries){

        entries.add(POPLAR_KEY, configureFeature(Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(NilsBlocks.POPLAR_LOG),
                new GiantTrunkPlacer(14,12,16),
                SimpleBlockStateProvider.of(NilsBlocks.POPLAR_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(7),ConstantIntProvider.create(0),ConstantIntProvider.create(2)),
                new TwoLayersFeatureSize(2,0,10)
        ).build()
        ));
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(NilsThingyMod.MODID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, ?> configureFeature(F feature, FC config) {
        return new ConfiguredFeature<>(feature, config);
    }

    public static void init() {
        // This just creates the registry keys.  Configured Features are requested and consumed by datagen now.
    }
}
