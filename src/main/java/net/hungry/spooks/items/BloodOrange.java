package net.hungry.spooks.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BloodOrange extends Item {
    public BloodOrange(Settings settings) {
        super(settings);
    }

    public static FoodComponent bloodOrangeFood = new FoodComponent.Builder().snack().nutrition(3).saturationModifier(0.25F).build();

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof LivingEntity) {
            var bloodOrangeStrength = new StatusEffectInstance(StatusEffects.STRENGTH, 2*20, 0, false, true, true);
            user.addStatusEffect(bloodOrangeStrength);
            user.tryEatFood(world, stack);
        }
        return (stack);
    }
}
