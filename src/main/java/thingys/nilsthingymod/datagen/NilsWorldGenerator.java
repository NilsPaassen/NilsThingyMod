package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.world.features.NilsConfiguredFeatures;
import thingys.nilsthingymod.world.features.NilsPlacedFeatures;

import java.util.concurrent.CompletableFuture;

public class NilsWorldGenerator extends FabricDynamicRegistryProvider {
    public NilsWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        NilsConfiguredFeatures.populate(entries);
        NilsPlacedFeatures.populate(entries);
    }

    @Override
    public String getName() {
        return "NilsThingyMod";
    }
}
