package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.content.Content;
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

public interface Block extends ItemProvider, Content<Block> {
    @Override
    default Class<Block> getContentType() {
        return Block.class;
    }

    /**
     * The {@link Settings} assigned to the Block
     */
    Settings getSettings();

    /**
     * Grabs the Block as an {@link Item}
     *
     * @return
     */
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

    class Settings {
        private final Material material;
        private float hardness, resistance, slipperiness, velocity, jumpVelocity;
        private int luminance, opacity;

        public Settings(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }

        public Settings withHardness(float hardness) {
            this.hardness = hardness;
            return this;
        }

        public Settings unbreakable() {
            return withHardness(-1);
        }

        public Settings withResistance(float resistance) {
            this.resistance = resistance;
            return this;
        }

        public Settings withLuminance(int luminance) {
            this.luminance = luminance;
            return this;
        }

        public Settings withStrength(float hardness, float resistance) {
            this.hardness = hardness;
            this.resistance = Math.max(0.0F, resistance);
            return this;
        }

        protected Block.Settings withStrength(float strength) {
            this.withStrength(strength, strength);
            return this;
        }

        public Block.Settings withVelocity(float velocity) {
            this.velocity = velocity;
            return this;
        }

        public Block.Settings withJumpVelocity(float jumpVelocity) {
            this.jumpVelocity = jumpVelocity;
            return this;
        }

        protected Settings breakInstantly() {
            return this.withStrength(0.0F);
        }

        public Settings setOpacity(int opacity) {
            this.opacity = opacity;
            return this;
        }

        public Settings setSlipperiness(float slipperiness) {
            this.slipperiness = slipperiness;
            return this;
        }

    }
}