package org.sandboxpowered.sandbox.api.state;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.Material;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mirror;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.Rotation;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;
import org.sandboxpowered.sandbox.api.world.WorldReader;

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

    default <X> Mono<X> getComponent(World world, Position position, Component<X> component) {
        return getComponent(world, position, component, Mono.empty());
    }

    default <X> Mono<X> getComponent(World world, Position position, Component<X> component, Direction side) {
        return getComponent(world, position, component, Mono.of(side));
    }

    default <X> Mono<X> getComponent(World world, Position position, Component<X> component, Mono<Direction> sideMono) {
        return getBlock().getComponent(world, position, this, component, sideMono);
    }
}