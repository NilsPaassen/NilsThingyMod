package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.item.food.Tea;

public class NilsDeutschLangProvider extends FabricLanguageProvider {
    protected NilsDeutschLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "de_de");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        /*Entitys*/
        translationBuilder.add(NilsThingyMod.GOBLIN,"Goblin");
        translationBuilder.add(NilsThingyMod.REDPANDA,"Roter Panda");

        /*Smaragd Material*/
        translationBuilder.add(NilsItems.DIAMOND_INFUSED_EMERALD,"Diamantener Smaragd");
        translationBuilder.add(NilsItems.EMERALD_SWORD,"Smaragd Schwert");

        /*Fenchel Anis Tee*/
        translationBuilder.add(Tea.FENNEL_ANISE_TEA, "Fenchel Anis Tee");
        translationBuilder.add(Tea.FENNEL,"Getrockneter Fenchel");
        translationBuilder.add(Tea.ANISE,"Getrockneter Anis");
        translationBuilder.add(Tea.FENNEL_SEED, "Fenchel Sammen");
        translationBuilder.add(Tea.ANISE_SEED, "Anis Sammen");
        translationBuilder.add(Tea.FENNEL_ANISE_MIX, "Fenchel Anis Mix");

        /*Tasse*/
        translationBuilder.add(NilsItems.CUP,"Tasse");

        /*Pappel*/
        translationBuilder.add(NilsBlocks.POPLAR_LOG, "Pappelstamm");
        translationBuilder.add(NilsBlocks.POPLAR_WOOD, "Pappelholz");
        translationBuilder.add(NilsBlocks.STRIPPED_POPLAR_LOG, "Entrindeter Pappestamm");
        translationBuilder.add(NilsBlocks.STRIPPED_POPLAR_WOOD, "Entrindetes Pappelholz");
        translationBuilder.add(NilsBlocks.POPLAR_LEAVES, "Pappellaub");
        translationBuilder.add(NilsBlocks.POPLAR_PLANKS, "Pappelbretter");
        translationBuilder.add(NilsBlocks.POPLAR_SAPLING, "Pappelsetzling");
    }
}
