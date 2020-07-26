package org.sandboxpowered.api.block.entity;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.internal.BlockEntityContext;

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

    public <X> Mono<X> getComponent(Component<X> component, @Nullable Direction side) {
        return Mono.empty();
    }
}
