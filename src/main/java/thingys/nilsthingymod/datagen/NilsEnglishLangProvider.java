package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.item.food.Tea;

public class NilsEnglishLangProvider extends FabricLanguageProvider {
    protected NilsEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        /*Entitys*/
        translationBuilder.add(NilsThingyMod.GOBLIN,"Goblin");
        translationBuilder.add(NilsThingyMod.REDPANDA,"Red Panda");

        /*Emerald Material*/
        translationBuilder.add(NilsItems.DIAMOND_INFUSED_EMERALD,"Diamond infused Emerald");
        translationBuilder.add(NilsItems.EMERALD_SWORD,"Emerald Sword");

        /*Fennel Anise Tea*/
        translationBuilder.add(Tea.FENNEL_ANISE_TEA, "Fennel Anise Tea");
        translationBuilder.add(Tea.FENNEL,"Dried Fennel");
        translationBuilder.add(Tea.ANISE,"Dried Anise");
        translationBuilder.add(Tea.FENNEL_SEED, "Fennel Seed");
        translationBuilder.add(Tea.ANISE_SEED, "Anise Seed");
        translationBuilder.add(Tea.FENNEL_ANISE_MIX, "Fenel Anise Mix");

        /*Cup*/
        translationBuilder.add(NilsItems.CUP,"Cup");

        /*Poplar*/
        translationBuilder.add(NilsBlocks.POPLAR_LOG, "Poplar Log");
        translationBuilder.add(NilsBlocks.POPLAR_WOOD, "Poplar Wood");
        translationBuilder.add(NilsBlocks.STRIPPED_POPLAR_LOG, "Stripped Poplar Log");
        translationBuilder.add(NilsBlocks.STRIPPED_POPLAR_WOOD, "Stripped Poplar Wood");
        translationBuilder.add(NilsBlocks.POPLAR_LEAVES, "Poplar Leaves");
        translationBuilder.add(NilsBlocks.POPLAR_PLANKS, "Poplar Planks");
        translationBuilder.add(NilsBlocks.POPLAR_SAPLING, "Poplar Sapling");
    }
}
