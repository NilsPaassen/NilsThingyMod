package thingys.nilsthingymod.item.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.item.NilsItems;

public class Tea {
    public static void initialize(){
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                        .register((ig) -> ig.add(FENNEL_ANISE_TEA));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(FENNEL));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ANISE));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(FENNEL_SEED));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(ANISE_SEED));
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(FENNEL_ANISE_MIX));
    }
    public static final FoodComponent FENNEL_ANISE_TEA_FOOD = new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).build();
    public static final Item FENNEL_ANISE_TEA = NilsItems.registerItem(
            (Item)  (new FennelAnisTea(
                    new FabricItemSettings().recipeRemainder(NilsItems.CUP).maxCount(1).food(FENNEL_ANISE_TEA_FOOD)
            )),
            "fennel_anise_tea"
    );
    public static final Item FENNEL = NilsItems.registerItem(
            new Item(
                    new FabricItemSettings()
            ),"fennel"
    );
    public static final Item FENNEL_SEED = NilsItems.registerItem(
            new AliasedBlockItem(
                    NilsBlocks.FENNEL_CROP,
                    new FabricItemSettings()
            ),"fennel_seed"
    );

    public static final Item ANISE_SEED = NilsItems.registerItem(
            new AliasedBlockItem(
                    NilsBlocks.ANNISE_CROP,
                    new FabricItemSettings()
            ),"anise_seed"
    );

    public static final Item ANISE= NilsItems.registerItem(
            new Item(
                    new FabricItemSettings()
            ),"anise"
    );

    public static final Item FENNEL_ANISE_MIX = NilsItems.registerItem(
            new Item(
                    new FabricItemSettings()
            ),"fennel_anise_mix"
    );

}
