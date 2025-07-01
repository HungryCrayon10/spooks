package net.hungry.spooks.items;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import static net.hungry.spooks.register.SpooksBlocks.GHOST_PEPPERS_CROP;

public class GhostPeppers extends AliasedBlockItem {
    public GhostPeppers(Settings settings) {
        super(GHOST_PEPPERS_CROP, settings);
    }

    public static FoodComponent ghostPepperFood = new FoodComponent.Builder().snack().nutrition(3).saturationModifier(0.25F).build();

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof LivingEntity) {
            var ghostPepperInvis = new StatusEffectInstance(StatusEffects.INVISIBILITY, 2*20, 0, false, true, true);
            user.addStatusEffect(ghostPepperInvis);
            user.tryEatFood(world, stack);
        }
        return (stack);
    }
}
