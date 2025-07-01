package net.hungry.spooks.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class DeltaThymeGrowth extends MultifaceGrowthBlock {
    public DeltaThymeGrowth(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return null;
    }

    public static boolean canGrowOn(BlockView world, Direction direction, BlockPos pos, BlockState state) {
        return (Block.isFaceFullSquare(state.getSidesShape(world, pos), direction.getOpposite()) && state.isOf(Blocks.BASALT))
                || (Block.isFaceFullSquare(state.getCollisionShape(world, pos), direction.getOpposite()) && state.isOf(Blocks.BASALT));
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        boolean bl = false;

        for (Direction direction : DIRECTIONS) {
            if (hasDirection(state, direction)) {
                BlockPos blockPos = pos.offset(direction);
                if (!canGrowOn(world, direction, blockPos, world.getBlockState(blockPos))) {
                    return false;
                }

                bl = true;
            }
        }

        return bl;
    }

    public LichenGrower getGrower() {
        return null;
    }
}

