package thingys.nilsthingymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.crops.AniseCropBlock;
import thingys.nilsthingymod.block.crops.FennelCropBlock;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.world.features.NilsConfiguredFeatures;

import java.util.Optional;

public class NilsBlocks {

    public static void intitialize(){
        StrippableBlockRegistry.register(POPLAR_LOG, STRIPPED_POPLAR_LOG);
        StrippableBlockRegistry.register(POPLAR_WOOD, STRIPPED_POPLAR_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(POPLAR_PLANKS,5,25);
        FlammableBlockRegistry.getDefaultInstance().add(POPLAR_LOG,5,10);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_POPLAR_LOG,5,10);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_POPLAR_WOOD,5,10);
        FlammableBlockRegistry.getDefaultInstance().add(POPLAR_WOOD,5,10);
        FlammableBlockRegistry.getDefaultInstance().add(POPLAR_LEAVES,5,10);

    }





    public static <T extends Block> T register(T block, String id) {

        return  Registry.register(Registries.BLOCK, new Identifier(NilsThingyMod.MODID, id), block);
    }
    public static BlockItem registerBlockItem(Block block, String id){
        return Registry.register(Registries.ITEM, new Identifier(NilsThingyMod.MODID, id), new BlockItem(block, new FabricItemSettings()));
    }
    //Crops
    public static Block FENNEL_CROP = register(
            new FennelCropBlock(
                    FabricBlockSettings.copyOf(Blocks.WHEAT)
            ),
            "fennel_crop"
    );

    public static Block ANNISE_CROP = register(
            new AniseCropBlock(
                    FabricBlockSettings.copyOf(Blocks.WHEAT)
            ),
            "anise_crop"
    );
    //Trees
    //Log
    public static Block POPLAR_LOG = register(
            new PillarBlock(
                    FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2)
            ),"poplar_log"
    );
    public  static BlockItem POPLAR_LOG_ITEM = registerBlockItem(POPLAR_LOG, "poplar_log");
    //Wood
    public static Block POPLAR_WOOD = register(
            new PillarBlock(
                    FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2)
            ),"poplar_wood"
    );
    public  static BlockItem POPLAR_WOOD_ITEM = registerBlockItem(POPLAR_WOOD, "poplar_wood");
    //S_Log
    public static Block STRIPPED_POPLAR_LOG = register(
            new PillarBlock(
                    FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(2)
            ),"stripped_poplar_log"
    );
    public  static BlockItem STRIPPED_POPLAR_LOG_ITEM = registerBlockItem(STRIPPED_POPLAR_LOG, "stripped_poplar_log");
    //S_Wood

    public static Block STRIPPED_POPLAR_WOOD = register(
            new PillarBlock(
                    FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(2)
            ),"stripped_poplar_wood"
    );
    public  static BlockItem STRIPPED_POPLAR_WOOD_ITEM = registerBlockItem(STRIPPED_POPLAR_WOOD, "stripped_poplar_wood");
    //Planks
    public static Block POPLAR_PLANKS = register(
            new Block(
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2)
            ),"poplar_planks"
    );
    public  static BlockItem POPLAR_PLANKS_ITEM = registerBlockItem(POPLAR_PLANKS, "poplar_planks");
    //Leaves
    public static Block POPLAR_LEAVES = register(
            new LeavesBlock(
                    FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()
            ),"poplar_leaves"
    );
    public  static BlockItem POPLAR_LEAVES_ITEM = registerBlockItem(POPLAR_LEAVES, "poplar_leaves");

    //Saplings
    public static SaplingBlock POPLAR_SAPLING = register(new SaplingBlock(
            new SaplingGenerator(
                    "poplar",
                    0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(NilsConfiguredFeatures.POPLAR_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
                ),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
            ), "poplar_sapling"
    );
    public static BlockItem POPLAR_SAPLING_ITEM = registerBlockItem(POPLAR_SAPLING,"poplar_sapling");

}
