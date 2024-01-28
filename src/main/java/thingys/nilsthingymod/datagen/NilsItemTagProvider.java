package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import thingys.nilsthingymod.block.NilsBlocks;

import java.util.concurrent.CompletableFuture;

public class NilsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NilsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(NilsBlocks.POPLAR_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(NilsBlocks.POPLAR_LOG.asItem())
                .add(NilsBlocks.POPLAR_WOOD.asItem())
                .add(NilsBlocks.STRIPPED_POPLAR_WOOD.asItem())
                .add(NilsBlocks.STRIPPED_POPLAR_LOG.asItem());
    }
}
