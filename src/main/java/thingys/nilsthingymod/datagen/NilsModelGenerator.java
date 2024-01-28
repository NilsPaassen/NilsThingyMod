package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.block.crops.AniseCropBlock;
import thingys.nilsthingymod.block.crops.FennelCropBlock;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.item.food.Tea;

public class NilsModelGenerator extends FabricModelProvider {

    public NilsModelGenerator(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(NilsBlocks.FENNEL_CROP, FennelCropBlock.AGE, 0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(NilsBlocks.ANNISE_CROP, AniseCropBlock.AGE, 0,1,2,3,4,5);

        //Wood
        blockStateModelGenerator.registerLog(NilsBlocks.POPLAR_LOG).log(NilsBlocks.POPLAR_LOG).wood(NilsBlocks.POPLAR_WOOD);
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.POPLAR_LOG, Identifier.of(NilsThingyMod.MODID,"block/poplar_log"));
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.POPLAR_WOOD, Identifier.of(NilsThingyMod.MODID,"block/poplar_wood"));

        blockStateModelGenerator.registerLog(NilsBlocks.STRIPPED_POPLAR_LOG).log(NilsBlocks.STRIPPED_POPLAR_LOG).wood(NilsBlocks.STRIPPED_POPLAR_WOOD);
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.STRIPPED_POPLAR_LOG, Identifier.of(NilsThingyMod.MODID,"block/stripped_poplar_log"));
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.STRIPPED_POPLAR_WOOD, Identifier.of(NilsThingyMod.MODID,"block/stripped_poplar_wood"));

        blockStateModelGenerator.registerSimpleCubeAll(NilsBlocks.POPLAR_LEAVES);
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.POPLAR_LEAVES, Identifier.of(NilsThingyMod.MODID,"block/poplar_leaves"));

        blockStateModelGenerator.registerSimpleCubeAll(NilsBlocks.POPLAR_PLANKS);
        blockStateModelGenerator.registerParentedItemModel(NilsBlocks.POPLAR_PLANKS, Identifier.of(NilsThingyMod.MODID,"block/poplar_planks"));

        //Saplings
        blockStateModelGenerator.registerTintableCross(NilsBlocks.POPLAR_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(NilsItems.DIAMOND_INFUSED_EMERALD, Models.GENERATED);
        itemModelGenerator.register(NilsItems.EMERALD_SWORD, Models.HANDHELD);

        itemModelGenerator.register(Tea.FENNEL_ANISE_TEA,Models.GENERATED);
        itemModelGenerator.register(Tea.ANISE,Models.GENERATED);
        itemModelGenerator.register(Tea.FENNEL,Models.GENERATED);
        itemModelGenerator.register(Tea.FENNEL_ANISE_MIX,Models.GENERATED);

        itemModelGenerator.register(NilsItems.CUP,Models.GENERATED);

    }
}
