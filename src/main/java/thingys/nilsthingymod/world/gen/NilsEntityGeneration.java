package thingys.nilsthingymod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import thingys.nilsthingymod.NilsThingyMod;

public class NilsEntityGeneration {
    public static void addSpawns(){
        /*++Goblin++*/
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                SpawnGroup.CREATURE,
                NilsThingyMod.GOBLIN,
                1,
                1,
                1);
        SpawnRestriction.register(
                NilsThingyMod.GOBLIN,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                WanderingTraderEntity::canMobSpawn
                );
        /*--Goblin--*/

        /*++Redpanda++*/
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.JUNGLE,BiomeKeys.BAMBOO_JUNGLE,BiomeKeys.LUSH_CAVES,BiomeKeys.WINDSWEPT_HILLS,BiomeKeys.OLD_GROWTH_PINE_TAIGA),
                SpawnGroup.CREATURE,
                NilsThingyMod.REDPANDA,
                10,
                1,
                2);
        SpawnRestriction.register(
                NilsThingyMod.REDPANDA,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING,
                TameableEntity::isValidNaturalSpawn
        );
        /*--Redpanda--*/
    }
}
