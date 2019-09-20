package com.hrznstudio.sandbox.api.state;

import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.block.Material;
import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.Mirror;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.util.Rotation;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.WorldReader;

public interface BlockState extends PropertyContainer<BlockState> {
    IBlock getBlock();

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
        return getComponent(world, position, component, Mono.empty());
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component, Direction side) {
        return getComponent(world, position, component, Mono.of(side));
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component, Mono<Direction> sideMono) {
        return getBlock().getComponent(world, position, this, component, sideMono);
    }
}