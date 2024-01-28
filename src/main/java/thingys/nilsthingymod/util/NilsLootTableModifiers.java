package thingys.nilsthingymod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;
import thingys.nilsthingymod.item.food.Tea;

public class NilsLootTableModifiers {
    private static final Identifier BLOCKS_SHORT_GRASS_ID = new Identifier("minecraft", "blocks/short_grass");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BLOCKS_SHORT_GRASS_ID.equals(id)){
                tableBuilder.pool(
                  LootPool.builder()
                          .rolls(BinomialLootNumberProvider.create(1,0.5f))
                          .conditionally(RandomChanceLootCondition.builder(0.1f))
                          .with(ItemEntry.builder(Tea.FENNEL_SEED))
                          .with(ItemEntry.builder(Tea.ANISE_SEED))
                          .with(ItemEntry.builder(Items.WHEAT_SEEDS))
                          .build()
                );
            }
        });
    }
}
