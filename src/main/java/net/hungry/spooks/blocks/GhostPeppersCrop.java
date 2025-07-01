package net.hungry.spooks.blocks;

import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.shape.VoxelShape;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.WorldView;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.hungry.spooks.register.SpooksItems;
import net.minecraft.state.StateManager;

import static net.hungry.spooks.register.SpooksBlocks.HOLLOWED_GROUND;
import static net.minecraft.block.Blocks.SOUL_SOIL;

public class GhostPeppersCrop extends PlantBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape SMALL_BUSH = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 6.0, 13.0);
    private static final VoxelShape MEDIUM_BUSH = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0);
    private static final VoxelShape LARGE_BUSH = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 15.0);

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    public GhostPeppersCrop(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((Integer)state.get(AGE) == 0) {
            return SMALL_BUSH;
        }
        if ((Integer)state.get(AGE) == 1) {
            return MEDIUM_BUSH;
        }
        else {
            return state.get(AGE) < 3 ? LARGE_BUSH : super.getOutlineShape(state, world, pos, context);
        }
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(SOUL_SOIL) || floor.isOf(HOLLOWED_GROUND);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 3;
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 3 && random.nextInt(10) == 0) {
            if (world.getBlockState(pos.down()).isOf(SOUL_SOIL)) {
                state = state.with(AGE, i + 1);
                world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
            }
            else {
                world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
            }
        }
        if (state.get(AGE) == 3 & world.getBlockState(pos.down()).isOf(SOUL_SOIL)) {
            world.setBlockState(pos.down(), HOLLOWED_GROUND.getDefaultState());
        }
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(AGE) == 3) {
            double X = pos.getX();
            double Y = pos.getY() + 0.7;
            double Z = pos.getZ();
            double X2 = random.nextDouble();
            double Z2 = random.nextDouble();
            if (random.nextDouble() < 0.1) {
                world.addParticle(ParticleTypes.SOUL, X + X2, Y, Z + Z2, 0.0, 0.03, 0.0);
            }
        }
    }

    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(SpooksItems.GHOST_PEPPERS);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}