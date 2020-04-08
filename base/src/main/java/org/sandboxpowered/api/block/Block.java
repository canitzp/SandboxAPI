package org.sandboxpowered.api.block;

import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.*;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3f;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;

import javax.annotation.Nullable;
import java.util.Optional;

public interface Block extends ItemProvider, Content<Block> {
    Registry<Block> REGISTRY = Registry.getRegistryFromType(Block.class);

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
     */
    @Override
    Optional<Item> asItem();

    default <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component) {
        return getComponent(world, position, state, component, null);
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, @Nullable Direction side) {
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
        private final float hardness, resistance, slipperiness, velocity, jumpVelocity;
        private final int luminance;

        private Settings(Material material, float hardness, float resistance, float slipperiness, float velocity, float jumpVelocity, int luminance) {
            this.material = material;
            this.hardness = hardness;
            this.resistance = resistance;
            this.slipperiness = slipperiness;
            this.velocity = velocity;
            this.jumpVelocity = jumpVelocity;
            this.luminance = luminance;
        }

        public static Builder builder(Material material) {
            return new Builder(material);
        }

        public Material getMaterial() {
            return material;
        }

        public float getHardness() {
            return hardness;
        }

        public float getResistance() {
            return resistance;
        }

        public float getSlipperiness() {
            return slipperiness;
        }

        public float getVelocity() {
            return velocity;
        }

        public float getJumpVelocity() {
            return jumpVelocity;
        }

        public int getLuminance() {
            return luminance;
        }

        public static class Builder {
            private final Material material;
            private float hardness, resistance, slipperiness, velocity, jumpVelocity;
            private int luminance, opacity;

            private Builder(Material material) {
                this.material = material;
            }

            public Builder setHardness(float hardness) {
                this.hardness = hardness;
                return this;
            }

            public Builder setResistance(float resistance) {
                this.resistance = resistance;
                return this;
            }

            public Builder setSlipperiness(float slipperiness) {
                this.slipperiness = slipperiness;
                return this;
            }

            public Builder setVelocity(float velocity) {
                this.velocity = velocity;
                return this;
            }

            public Builder setJumpVelocity(float jumpVelocity) {
                this.jumpVelocity = jumpVelocity;
                return this;
            }

            public Builder setLuminance(int luminance) {
                this.luminance = luminance;
                return this;
            }

            public Settings build() {
                return new Settings(material, hardness, resistance, slipperiness, velocity, jumpVelocity, luminance);
            }
        }
    }
}