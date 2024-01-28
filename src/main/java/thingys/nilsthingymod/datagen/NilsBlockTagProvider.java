package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import thingys.nilsthingymod.block.NilsBlocks;

import java.util.concurrent.CompletableFuture;

public class NilsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public NilsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(NilsBlocks.POPLAR_LOG)
                .add(NilsBlocks.POPLAR_WOOD)
                .add(NilsBlocks.STRIPPED_POPLAR_WOOD)
                .add(NilsBlocks.STRIPPED_POPLAR_LOG);
    }
}
