package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.world.features.NilsPlacedFeatures;
import thingys.nilsthingymod.world.gen.NilsTreeGeneration;

public class NilsThingyModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(NilsModelGenerator::new);

		pack.addProvider(NilsEnglishLangProvider::new);
		pack.addProvider(NilsDeutschLangProvider::new);

		pack.addProvider(NilsRecipeGenerator::new);
		pack.addProvider(NilsLootTableProvider::new);

		pack.addProvider(NilsItemTagProvider::new);
		pack.addProvider(NilsBlockTagProvider::new);

		pack.addProvider(NilsWorldGenerator::new);
	}
}
