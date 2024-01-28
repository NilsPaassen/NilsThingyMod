package thingys.nilsthingymod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import thingys.nilsthingymod.world.features.NilsPlacedFeatures;

public class NilsTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.WINDSWEPT_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, NilsPlacedFeatures.POPLAR_PLACED_KEY
        );
    }
}
