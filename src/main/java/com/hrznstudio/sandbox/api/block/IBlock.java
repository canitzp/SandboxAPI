package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.entity.IEntity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.fluid.Fluids;
import com.hrznstudio.sandbox.api.fluid.IFluid;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.state.FluidState;
import com.hrznstudio.sandbox.api.state.Properties;
import com.hrznstudio.sandbox.api.state.StateFactory;
import com.hrznstudio.sandbox.api.util.*;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;
import com.hrznstudio.sandbox.api.world.WorldReader;

import javax.annotation.Nullable;

public interface IBlock extends ItemProvider {

    /**
     * The {@link Settings} assigned to the Block
     */
    Settings getSettings();

    /**
     * Grabs the Block as an {@link IItem}
     */
    @Nullable
    @Override
    IItem asItem();

    default <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component) {
        return getComponent(world, position, state, component, Mono.empty());
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Direction side) {
        return getComponent(world, position, state, component, Mono.of(side));
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Mono<Direction> side) {
        return Mono.empty();
    }

    /**
     * Gets called when the block is interacted with by a {@link Player}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    /**
     * Gets called when the block is clicked by a {@link Player}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, Player player) {
        return InteractionResult.IGNORE;
    }

    BlockState getBaseState();

    StateFactory<IBlock, BlockState> getStateFactory();

    /**
     * Gets called when the block is placed
     */
    default void onBlockPlaced(World world, Position position, BlockState state, IEntity entity, ItemStack itemStack) {
    }

    /**
     * Gets called when the block is broken
     */
    default void onBlockBroken(World world, Position position, BlockState state) {
    }

    /**
     * Updates the @{@link BlockState} when a neighbor block updates
     *
     * @return The @{@link BlockState} to set in the world
     */
    default BlockState updateOnNeighborChanged(BlockState state, Direction direction, BlockState otherState, World world, Position position, Position otherPosition) {
        return state;
    }

    /**
     * Whether the block has a @{@link IBlockEntity} attached to it
     */
    default boolean hasBlockEntity() {
        return false;
    }

    /**
     * Creates a new @{@link IBlockEntity} for this block
     * <p>
     * Make sure to return true in @{@link this#hasBlockEntity()} to use this
     */
    @Nullable
    default IBlockEntity createBlockEntity(WorldReader reader) {
        return null;
    }

    default BlockState rotate(BlockState state, Rotation rotation) {
        return state;
    }

    default BlockState mirror(BlockState state, Mirror mirror) {
        return state;
    }

    default boolean canReplace(BlockState state) {
        return getMaterial().isReplaceable();
    }

    default boolean isAir(BlockState state) {
        return false;
    }

    default void onEntityWalk(World world, Position position, IEntity entity) {

    }

    default boolean canEntitySpawnWithin() {
        return !getMaterial().isSolid() && !getMaterial().isLiquid();
    }

    default Material.PistonInteraction getPistonInteraction(BlockState state) {
        return getMaterial().getPistonInteraction();
    }

    default Material getMaterial() {
        return getSettings().getMaterial();
    }

    default ItemStack getPickStack(WorldReader reader, Position position, BlockState state) {
        return ItemStack.of(this);
    }

    default boolean isNaturalDirt() {
        return false;
    }

    default boolean isNaturalStone() {
        return false;
    }

    default boolean canContainFluids() {
        return false;
    }

    default boolean canContainFluid(WorldReader world, Position position, BlockState state, IFluid fluid) {
        return canContainFluids();
    }

    default boolean fillWith(World world, Position position, BlockState state, FluidState fluid) {
        if (canContainFluid(world, position, state, fluid.getFluid())) {
            world.setBlockState(position, state.with(Properties.WATERLOGGED, true));
            return true;
        }
        return false;
    }

    default IFluid drainFrom(World world, Position position, BlockState state) {
        if (state.contains(Properties.WATERLOGGED)) {
            world.setBlockState(position, state.with(Properties.WATERLOGGED, false));
            return Fluids.WATER;
        }
        return Fluids.EMPTY;
    }

    class Settings {
        private final Material material;

        public Settings(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }
}