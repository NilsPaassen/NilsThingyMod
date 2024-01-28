package thingys.nilsthingymod.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import thingys.nilsthingymod.item.NilsItems;

public class EmeraldMaterial implements ToolMaterial {
    public static final  EmeraldMaterial INSTANCE = new EmeraldMaterial();
    @Override
    public int getDurability() {
        return 1234;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 3f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(NilsItems.DIAMOND_INFUSED_EMERALD);
    }
}
