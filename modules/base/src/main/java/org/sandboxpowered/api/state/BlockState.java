package org.sandboxpowered.api.state;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.client.GraphicsMode;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mirror;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.Rotation;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.WorldReader;

public interface BlockState extends PropertyContainer<BlockState> {
    Block getBlock();

    default boolean isAir() {
        return getBlock().isAir(this);
    }

    default Material.PistonInteraction getPistonInteraction() {
        return getBlock().getPistonInteraction(this);
    }

    /**
     * @deprecated <p> Use {@link BlockState#canReplace(WorldReader, Position, PlayerEntity, Hand, ItemStack, Direction, Vec3d)} instead.
     */
    @Deprecated
    default boolean canReplace() {
        return getBlock().canReplace(this);
    }

    default boolean canReplace(WorldReader reader, Position pos, PlayerEntity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return getBlock().canReplace(reader, pos, this, player, hand, stack, side, hitPos);
    }

    default Block.BlockRenderLayer getRenderLayer(GraphicsMode mode) {
        return getBlock().getRenderLayer(this, mode);
    }

    default BlockState rotate(Rotation rotation) {
        return getBlock().rotate(this, rotation);
    }

    default BlockState mirror(Mirror mirror) {
        return getBlock().mirror(this, mirror);
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component) {
        return getComponent(world, position, component, null);
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component, @Nullable Direction side) {
        return getBlock().getComponent(world, position, this, component, side);
    }

    default boolean emitsRedstone() {
        return getBlock().emitsRedstone(this);
    }

    default boolean hasComparatorValue() {
        return getBlock().hasComparatorValue(this);
    }

    default int getComparatorValue(WorldReader world, Position pos) {
        return getBlock().getComparatorValue(world, pos, this);
    }

    default int getWeakPower(WorldReader blockView, Position pos, Direction direction) {
        return getBlock().getWeakPower(blockView, pos, this, direction);
    }

    default int getStrongPower(WorldReader blockView, Position pos, Direction direction) {
        return getBlock().getStrongPower(blockView, pos, this, direction);
    }

    default boolean is(Block block) {
        return getBlock().isSame(block) || block.isSame(getBlock());
    }

    default boolean is(Registry.Entry<Block> entry) {
        return entry.isPresent() && is(entry.get());
    }
}