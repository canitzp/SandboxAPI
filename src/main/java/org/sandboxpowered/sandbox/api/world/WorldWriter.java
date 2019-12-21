package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.InteractionResult;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;

public interface WorldWriter {
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

    default boolean breakBlock(Position position, boolean drop, Entity entity) {
        return breakBlock(position, drop, Mono.of(entity));
    }

    default boolean breakBlock(Position position, boolean drop) {
        return breakBlock(position, drop, Mono.empty());
    }

    boolean breakBlock(Position position, boolean drop, Mono<Entity> entity);
}