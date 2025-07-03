package net.hungry.spooks.items;

import net.hungry.spooks.register.SpooksEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.hungry.spooks.register.SpooksBlocks.WASTESHROOM_PLANT;

public class Wasteshroom extends AliasedBlockItem {
    public Wasteshroom(Settings settings) {
        super(WASTESHROOM_PLANT, settings);
    }

    public static FoodComponent wasteshroomFood = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.25F).build();

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof LivingEntity) {
            var wasteshroomHigh = new StatusEffectInstance(SpooksEffects.WASTED, 480*20, 0, false, false, true);
            user.addStatusEffect(wasteshroomHigh);
            user.tryEatFood(world, stack);
        }
        return (stack);
    }
}
