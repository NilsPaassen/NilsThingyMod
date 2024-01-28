package thingys.nilsthingymod.item.food;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import thingys.nilsthingymod.item.NilsItems;

public class FennelAnisTea extends HoneyBottleItem {


    public FennelAnisTea(Settings settings) {
        super(settings);
    }


    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.POISON);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200));
        }

        if (stack.isEmpty()) {
            return new ItemStack(NilsItems.CUP);
        } else {
            if (user instanceof PlayerEntity playerEntity) {
                if (!playerEntity.getAbilities().creativeMode) {
                    ItemStack itemStack = new ItemStack(NilsItems.CUP);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }

            return stack;
        }
    }

}
