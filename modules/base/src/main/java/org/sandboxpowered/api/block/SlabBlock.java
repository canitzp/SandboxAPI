package org.sandboxpowered.api.block;

import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.fluid.Fluids;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.state.Properties;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.SlabType;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.WorldReader;

public class SlabBlock extends BaseBlock implements FluidLoggable {
    protected static final Shape BOTTOM_SHAPE = Shape.cube(0, 0, 0, 1, 0.5, 1);
    protected static final Shape TOP_SHAPE = Shape.cube(0, 0.5, 0, 1, 1, 1);

    public SlabBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected BlockState createBaseState(BlockState baseState) {
        return baseState.with(Properties.SLAB_TYPE, SlabType.BOTTOM).with(Properties.WATERLOGGED, false);
    }

    @Override
    public void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.SLAB_TYPE);
    }

    @Override
    public Shape getShape(WorldReader reader, Position position, BlockState state) {
        SlabType type = state.get(Properties.SLAB_TYPE);
        return type == SlabType.BOTTOM ? BOTTOM_SHAPE : type == SlabType.TOP ? TOP_SHAPE : super.getShape(reader, position, state);
    }

    @Override
    public BlockState getStateForPlacement(WorldReader reader, Position pos, PlayerEntity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        BlockState state = reader.getBlockState(pos);
        if (state.is(this)) {
            return state.with(Properties.SLAB_TYPE, SlabType.DOUBLE).with(Properties.WATERLOGGED, false);
        }
        FluidState fluidState = reader.getFluidState(pos);
        BlockState newState = getBaseState().with(Properties.WATERLOGGED, Fluids.WATER.matches(fluidState.getFluid()));
        return newState.with(Properties.SLAB_TYPE, side == Direction.DOWN || (side != Direction.UP && hitPos.getY() - pos.getY() > 0.5f) ? SlabType.TOP : SlabType.BOTTOM);
    }

    @Override
    public boolean canReplace(WorldReader reader, Position pos, BlockState currentState, PlayerEntity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        SlabType slabType = currentState.get(Properties.SLAB_TYPE);
        if (slabType != SlabType.DOUBLE && asItem().filter(item -> item == stack.getItem()).isPresent()) {
            boolean isAbove = hitPos.getY() - pos.getY() > 0.5D;
            return slabType == SlabType.TOP ? side == Direction.UP || !isAbove && side.getAxis().isHorizontal() : side == Direction.DOWN || isAbove && side.getAxis().isHorizontal();
        } else {
            return false;
        }
    }
}