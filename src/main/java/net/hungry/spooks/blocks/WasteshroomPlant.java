package net.hungry.spooks.blocks;
import com.mojang.serialization.MapCodec;
import net.hungry.spooks.register.SpooksItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import static net.hungry.spooks.register.SpooksBlocks.WASTESHROOM_PLANT;
import static net.minecraft.block.Blocks.*;

public class WasteshroomPlant extends PlantBlock {
    public WasteshroomPlant(Settings settings) {
		super(settings);
    }

    private static final VoxelShape MUSHROOM_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 6.0, 13.0);

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return MUSHROOM_SHAPE;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(NETHERRACK);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.getBlockState(pos.down()).isOf(NETHERRACK)) {
            world.setBlockState(pos.up(0), AIR.getDefaultState());
        }
        if (random.nextInt(25) == 1 && world.getBlockState(pos.east()).isOf(AIR) && world.getBlockState(pos.east().down()).isOf(NETHERRACK)) {
            world.setBlockState(pos.east(), WASTESHROOM_PLANT.getDefaultState());
        }
        if (random.nextInt(25) == 1 && world.getBlockState(pos.west()).isOf(AIR) && world.getBlockState(pos.west().down()).isOf(NETHERRACK)) {
            world.setBlockState(pos.west(), WASTESHROOM_PLANT.getDefaultState());
        }
        if (random.nextInt(25) == 1 && world.getBlockState(pos.north()).isOf(AIR) && world.getBlockState(pos.north().down()).isOf(NETHERRACK)) {
            world.setBlockState(pos.north(), WASTESHROOM_PLANT.getDefaultState());
        }
        if (random.nextInt(25) == 1 && world.getBlockState(pos.south()).isOf(AIR) && world.getBlockState(pos.south().down()).isOf(NETHERRACK)) {
            world.setBlockState(pos.south(), WASTESHROOM_PLANT.getDefaultState());
        }
    }

    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(SpooksItems.WASTESHROOM);
    }
}
