package net.hungry.spooks.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;

import static net.hungry.spooks.register.SpooksBlocks.DELTA_THYME_GROWTH;

public class DeltaThyme extends AliasedBlockItem {
    public DeltaThyme(Settings settings) {
        super(DELTA_THYME_GROWTH, settings);
    }
    public static FoodComponent deltaThymeFood = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.25F).build();
}
