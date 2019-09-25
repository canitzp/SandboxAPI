package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.entity.player.Hand;
import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.ItemProvider;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.*;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3f;
import org.sandboxpowered.sandbox.api.world.World;
import org.sandboxpowered.sandbox.api.world.WorldReader;

import javax.annotation.Nullable;

public interface Block extends ItemProvider {

    /**
     * The {@link Settings} assigned to the Block
     */
    Settings getSettings();

    /**
     * Grabs the Block as an {@link Item}
     * @return
     */
    @Nullable
    @Override
    Mono<Item> asItem();

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
     * Gets called when the block is interacted with by a {@link PlayerEntity}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, PlayerEntity player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    /**
     * Gets called when the block is clicked by a {@link PlayerEntity}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, PlayerEntity player) {
        return InteractionResult.IGNORE;
    }

    BlockState getBaseState();

    StateFactory<Block, BlockState> getStateFactory();

    /**
     * Gets called when the block is placed
     */
    default void onBlockPlaced(World world, Position position, BlockState state, Entity entity, ItemStack itemStack) {
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
     * Whether the block has a @{@link BlockEntity} attached to it
     */
    default boolean hasBlockEntity() {
        return false;
    }

    /**
     * Creates a new @{@link BlockEntity} for this block
     * <p>
     * Make sure to return true in @{@link this#hasBlockEntity()} to use this
     */
    @Nullable
    default BlockEntity createBlockEntity(WorldReader reader) {
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

    default void onEntityWalk(World world, Position position, Entity entity) {

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