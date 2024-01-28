package thingys.nilsthingymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.datagen.NilsRecipeGenerator;
import thingys.nilsthingymod.item.food.Tea;
import thingys.nilsthingymod.materials.EmeraldMaterial;

public class NilsItems {
    public static void initialize() {
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(EMERALD_SWORD));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(DIAMOND_INFUSED_EMERALD));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(CUP));

        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.POPLAR_LOG_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.POPLAR_WOOD_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.POPLAR_PLANKS_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.POPLAR_LEAVES_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.STRIPPED_POPLAR_LOG_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(NilsBlocks.STRIPPED_POPLAR_WOOD_ITEM));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.NATURAL)
                        .register((itemGroup) -> itemGroup.add(NilsBlocks.POPLAR_SAPLING_ITEM));

        Tea.initialize();
    }


    public static <T extends Item> T registerItem(T item, String ID) {
        return  Registry.register(Registries.ITEM, new Identifier(NilsThingyMod.MODID, ID), item);
    }

    public static final Item CUP = registerItem(
            new Item(
                    new FabricItemSettings()
            ),"cup"
    );

    public static final Item EMERALD_SWORD = registerItem(
            new SwordItem(
                    EmeraldMaterial.INSTANCE,2,1.6f, new FabricItemSettings()
            ),"emerald_sword"
    );

    public static final Item DIAMOND_INFUSED_EMERALD  = registerItem(
           new Item(
                   new FabricItemSettings()
           ),"diamond_infused_emerald"
    );
}
