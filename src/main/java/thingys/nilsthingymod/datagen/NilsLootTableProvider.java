package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.block.crops.AniseCropBlock;
import thingys.nilsthingymod.block.crops.FennelCropBlock;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.item.food.Tea;

public class NilsLootTableProvider extends FabricBlockLootTableProvider {
    protected NilsLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition
                .builder(NilsBlocks.FENNEL_CROP)
                .properties(StatePredicate.Builder
                        .create()
                        .exactMatch(FennelCropBlock.AGE,5)
                );
        addDrop(NilsBlocks.FENNEL_CROP, cropDrops(NilsBlocks.FENNEL_CROP, Tea.FENNEL_SEED, Tea.FENNEL_SEED, builder));

        builder = BlockStatePropertyLootCondition
                .builder(NilsBlocks.ANNISE_CROP)
                .properties(StatePredicate.Builder
                        .create()
                        .exactMatch(AniseCropBlock.AGE,5)
                );
        addDrop(NilsBlocks.ANNISE_CROP, cropDrops(NilsBlocks.ANNISE_CROP, Tea.ANISE_SEED, Tea.ANISE_SEED, builder));

        //WOOD
        addDrop(NilsBlocks.POPLAR_LOG);
        addDrop(NilsBlocks.POPLAR_WOOD);
        addDrop(NilsBlocks.STRIPPED_POPLAR_WOOD);
        addDrop(NilsBlocks.STRIPPED_POPLAR_LOG);
        addDrop(NilsBlocks.POPLAR_PLANKS);

        addDrop(NilsBlocks.POPLAR_LEAVES, leavesDrops(NilsBlocks.POPLAR_LEAVES, NilsBlocks.POPLAR_SAPLING, 0.001f));
    }
}
