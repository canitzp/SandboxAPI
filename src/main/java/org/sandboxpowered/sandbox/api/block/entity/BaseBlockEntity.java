package org.sandboxpowered.sandbox.api.block.entity;

import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Internal;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;

public abstract class BaseBlockEntity implements BlockEntity {
    private final Type<?> type;
    private BlockEntityContext context;

    public BaseBlockEntity(Type<?> type) {
        this.type = type;
    }

    @Internal
    public final void setContext(BlockEntityContext context) {
        this.context = context;
    }

    @Override
    public final World getWorld() {
        return context.getWorld();
    }

    @Override
    public final Position getPosition() {
        return context.getPosition();
    }

    @Override
    public final Type<?> getType() {
        return type;
    }

    @Override
    public final void save() {
        context.save();
    }

    public <X> Mono<X> getComponent(Component<X> component, Mono<Direction> side) {
        return Mono.empty();
    }
}
