package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.client.GraphicsMode;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.*;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.math.Vec3f;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;

import java.util.Optional;
import java.util.Random;

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
    default void onBlockClicked(World world, Position pos, BlockState state, PlayerEntity player) {

    }

    default BlockState getStateForPlacement(WorldReader reader, Position pos, PlayerEntity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return getBaseState();
    }

    default boolean isSame(Block block) {
        return this == block;
    }

    BlockState getBaseState();

    StateFactory<Block, BlockState> getStateFactory();

    default Shape getShape(WorldReader reader, Position position, BlockState state) {
        return Shape.fullCube();
    }

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

    default void randomTick(World serverWorld, Position position, BlockState blockState, Random random) {
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

    /**
     * @deprecated <p> Use {@link Block#canReplace(WorldReader, Position, BlockState, PlayerEntity, Hand, ItemStack, Direction, Vec3d)} instead.
     */
    @Deprecated
    default boolean canReplace(BlockState state) {
        return getMaterial(state).isReplaceable();
    }

    default boolean canReplace(WorldReader reader, Position pos, BlockState currentState, PlayerEntity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return canReplace(currentState);
    }

    default boolean isAir(BlockState state) {
        return false;
    }

    default void onEntityWalk(World world, Position position, Entity entity) {
    }

    default boolean canEntitySpawnWithin(BlockState state) {
        return !getMaterial(state).isSolid() && !getMaterial(state).isLiquid();
    }

    default Material.PistonInteraction getPistonInteraction(BlockState state) {
        return getMaterial(state).getPistonInteraction();
    }

    default boolean emitsRedstone(BlockState state) {
        return false;
    }

    default boolean hasComparatorValue(BlockState state) {
        return false;
    }

    default int getComparatorValue(WorldReader world, Position pos, BlockState state) {
        return 0;
    }

    default int getWeakPower(WorldReader blockView, Position pos, BlockState state, Direction direction) {
        return 0;
    }

    default int getStrongPower(WorldReader blockView, Position pos, BlockState state, Direction direction) {
        return 0;
    }

    default Material getMaterial(BlockState state) {
        return getSettings().getMaterial();
    }

    default float getHardness(BlockState state) {
        return getSettings().getHardness();
    }

    default float getResistance(BlockState state) {
        return getSettings().getResistance();
    }

    default float getSlipperiness(BlockState state) {
        return getSettings().getSlipperiness();
    }

    default float getVelocity(BlockState state) {
        return getSettings().getVelocity();
    }

    default float getJumpVelocity(BlockState state) {
        return getSettings().getJumpVelocity();
    }

    default int getLuminance(BlockState state) {
        return getSettings().getLuminance();
    }

    default ItemStack getPickStack(WorldReader reader, Position position, BlockState state) {
        return ItemStack.of(this);
    }

    default BlockRenderLayer getRenderLayer(BlockState state, GraphicsMode mode) {
        return BlockRenderLayer.SOLID;
    }

    default RenderType getRenderType() {
        return RenderType.MODEL;
    }

    enum BlockRenderLayer {
        SOLID,
        CUTOUT,
        CUTOUT_MIPPED,
        TRANSPARENT
    }

    enum RenderType {
        MODEL,
        DYNAMIC,
        INVISIBLE
    }

    //TODO: mining tool/level, map color, collision, opacity, sound group, random tick, drops, dynamic bounds
    class Settings {
        private final Material material;
        private final float hardness, resistance, slipperiness, velocity, jumpVelocity;
        private final int luminance;
        private final boolean randomTicks;

        private Settings(Material material, float hardness, float resistance, float slipperiness, float velocity, float jumpVelocity, int luminance, boolean randomTicks) {
            this.material = material;
            this.hardness = hardness;
            this.resistance = resistance;
            this.slipperiness = slipperiness;
            this.velocity = velocity;
            this.jumpVelocity = jumpVelocity;
            this.luminance = luminance;
            this.randomTicks = randomTicks;
        }

        public static Builder builder(Material material) {
            return new Builder(material);
        }

        public static Builder builder(Registry.Entry<Block> block) {
            return builder(block.get());
        }

        public static Builder builder(Block block) {
            return builder(block.getSettings());
        }

        public static Builder builder(Settings settings) {
            return new Builder(settings.material)
                    .setHardness(settings.hardness)
                    .setResistance(settings.resistance)
                    .setSlipperiness(settings.slipperiness)
                    .setVelocity(settings.velocity)
                    .setJumpVelocity(settings.jumpVelocity)
                    .setLuminance(settings.luminance)
                    .setRandomTicks(settings.randomTicks);
        }

        public boolean doesRandomTick() {
            return randomTicks;
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
            private float hardness, resistance, slipperiness = 0.6F, velocity = 1.0F, jumpVelocity = 1.0F;
            private int luminance, opacity;
            private boolean randomTicks;

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

            public Builder ticksRandomly() {
                this.randomTicks = true;
                return this;
            }

            public Settings build() {
                return new Settings(material, hardness, resistance, slipperiness, velocity, jumpVelocity, luminance, randomTicks);
            }

            private Builder setRandomTicks(boolean randomTicks) {
                this.randomTicks = randomTicks;
                return this;
            }
        }
    }
}