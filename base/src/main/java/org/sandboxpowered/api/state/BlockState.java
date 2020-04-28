package org.sandboxpowered.api.state;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mirror;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.Rotation;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.WorldReader;

public interface BlockState extends PropertyContainer<BlockState> {
    Block getBlock();

    default boolean isAir() {
        return getBlock().isAir(this);
    }

    default Material.PistonInteraction getPistonInteraction() {
        return getBlock().getPistonInteraction(this);
    }

    default boolean canReplace() {
        return getBlock().canReplace(this);
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
}