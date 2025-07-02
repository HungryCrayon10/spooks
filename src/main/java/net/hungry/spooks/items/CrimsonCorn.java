package net.hungry.spooks.items;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class CrimsonCorn extends Item {
    public CrimsonCorn(Settings settings) {
        super(settings);
    }

    public static FoodComponent crimsonCornFood = new FoodComponent.Builder().snack().nutrition(5).saturationModifier(0.25F).build();

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof LivingEntity) {
            var cornHype = new StatusEffectInstance(StatusEffects.HASTE, 2*20, 0, false, true, true);
            var cornVisibleHype = new StatusEffectInstance(StatusEffects.GLOWING, 2*20, 0, false, true, true);
            user.addStatusEffect(cornHype);
            user.addStatusEffect(cornVisibleHype);
            user.tryEatFood(world, stack);
        }
        return (stack);
    }
}
