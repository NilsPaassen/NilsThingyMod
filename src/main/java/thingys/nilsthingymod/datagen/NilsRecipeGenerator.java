package thingys.nilsthingymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.item.NilsItems;
import thingys.nilsthingymod.item.food.Tea;

import java.util.List;

public class NilsRecipeGenerator extends FabricRecipeProvider {
    public NilsRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /*Wood*/
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NilsBlocks.POPLAR_PLANKS_ITEM,4)
                .input(NilsBlocks.POPLAR_LOG_ITEM)
                .criterion(FabricRecipeProvider.hasItem(NilsBlocks.POPLAR_LOG_ITEM),FabricRecipeProvider.conditionsFromItem(NilsBlocks.POPLAR_LOG_ITEM))
                .offerTo(exporter);

        /*Diamond infused Emerald*/
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.MISC, NilsItems.DIAMOND_INFUSED_EMERALD)
                .input(Items.DIAMOND)
                .input(Items.EMERALD)
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND),FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .criterion(FabricRecipeProvider.hasItem(Items.EMERALD),FabricRecipeProvider.conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        /*Emerald Sword*/
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, NilsItems.EMERALD_SWORD)
                .pattern("e")
                .pattern("e")
                .pattern("s")
                .input('e', NilsItems.DIAMOND_INFUSED_EMERALD)
                .input('s',Items.STICK)
                .criterion(
                        FabricRecipeProvider.hasItem(NilsItems.DIAMOND_INFUSED_EMERALD),
                        FabricRecipeProvider.conditionsFromItem(NilsItems.DIAMOND_INFUSED_EMERALD))
                .criterion(
                        FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        /*Fennel Anise Tea*/
        RecipeProvider.offerSmelting(exporter, List.of(Tea.ANISE_SEED),RecipeCategory.FOOD,Tea.ANISE,5,300,"dry");
        RecipeProvider.offerSmelting(exporter, List.of(Tea.FENNEL_SEED),RecipeCategory.FOOD,Tea.FENNEL,5,300,"dry");

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.FOOD, Tea.FENNEL_ANISE_MIX)
                .input(Tea.FENNEL)
                .input(Tea.ANISE)
                .criterion(
                        FabricRecipeProvider.hasItem(Tea.FENNEL),
                        FabricRecipeProvider.conditionsFromItem(Tea.FENNEL)
                ).criterion(
                        FabricRecipeProvider.hasItem(Tea.ANISE),
                        FabricRecipeProvider.conditionsFromItem(Tea.ANISE)
                )
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.FOOD, Tea.FENNEL_ANISE_TEA)
                .input(Tea.FENNEL_ANISE_MIX)
                .input(NilsItems.CUP)
                .criterion(
                        FabricRecipeProvider.hasItem(Tea.FENNEL_ANISE_MIX),
                        FabricRecipeProvider.conditionsFromItem(Tea.FENNEL_ANISE_MIX)
                ).criterion(
                        FabricRecipeProvider.hasItem(NilsItems.CUP),
                        FabricRecipeProvider.conditionsFromItem(NilsItems.CUP)
                )
                .offerTo(exporter);

        /*Cup*/
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.FOOD, NilsItems.CUP)
                .pattern("c c")
                .pattern(" c ")
                .input('c', Items.CLAY_BALL)
                .criterion(
                        FabricRecipeProvider.hasItem(Items.CLAY_BALL),
                        FabricRecipeProvider.conditionsFromItem(Items.CLAY_BALL)
                )
                .offerTo(exporter);



    }

}
