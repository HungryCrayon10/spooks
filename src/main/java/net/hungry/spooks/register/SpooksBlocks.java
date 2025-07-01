package net.hungry.spooks.register;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;
import net.hungry.spooks.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.piston.PistonBehavior;

import static net.hungry.spooks.SpooksMain.MOD_ID;

public class SpooksBlocks {
    public static Block register(Block block, String id, boolean shouldRegisterItem) {
        Identifier itemID = Identifier.of(MOD_ID, id);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, itemID, blockItem);
        }
        return Registry.register(Registries.BLOCK, itemID, block);
    }
    public static final Block GHOST_PEPPERS_CROP = register(
            new GhostPeppersCrop(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CROP)
                    .noCollision()
                    .ticksRandomly()
                    .pistonBehavior(PistonBehavior.DESTROY)),
            "ghost_peppers_crop",
            false
    );
    public static final Block DELTA_THYME_GROWTH = register(
            new DeltaThymeGrowth(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GLOW_LICHEN)
                    .noCollision()
                    .pistonBehavior(PistonBehavior.DESTROY)),
            "delta_thyme_growth",
            false
    );
    public static final Block HOLLOWED_GROUND = register(
            new HollowedGround(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.SAND).strength(0.5F, 0.5F)),
            "hollowed_ground",
            true
    );

    public static void initialize() {
    }
}
