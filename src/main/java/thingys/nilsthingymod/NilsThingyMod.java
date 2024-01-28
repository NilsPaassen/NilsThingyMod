package thingys.nilsthingymod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.entity.Goblin;
import thingys.nilsthingymod.entity.Redpanda;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.util.NilsLootTableModifiers;
import thingys.nilsthingymod.world.NilsWorldGeneration;


public class NilsThingyMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("nilsthingymod");
	public static  final String MODID = "nilsthingymod";

	/*++Entities++*/
	public static final EntityType<Goblin> GOBLIN = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "goblin"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Goblin::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);



	public static final EntityType<Redpanda> REDPANDA = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "redpanda"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Redpanda::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	/*--Entities--*/

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(GOBLIN, Goblin.createMobAttributes());
		FabricDefaultAttributeRegistry.register(REDPANDA, Redpanda.createMobAttributes());
		NilsItems.initialize();
		NilsBlocks.intitialize();
		NilsLootTableModifiers.modifyLootTables();
		NilsWorldGeneration.generateNilsWorldGen();

	}
}