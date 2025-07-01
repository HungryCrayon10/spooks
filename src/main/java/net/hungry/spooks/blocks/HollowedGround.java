package net.hungry.spooks.blocks;

import net.minecraft.block.FallingBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import java.util.List;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class HollowedGround extends FallingBlock {
    public HollowedGround(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.spooks.hollowed_ground").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.spooks.hollowed_ground_hint").formatted(Formatting.GREEN));
    }
}
