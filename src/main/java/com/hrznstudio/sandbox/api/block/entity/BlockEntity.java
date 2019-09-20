package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public abstract class BlockEntity implements IBlockEntity {
    private final Type<?> type;
    private BlockEntityCTX ctx;

    public BlockEntity(Type<?> type) {
        this.type = type;
    }

    public final void setCtx(BlockEntityCTX ctx) {
        this.ctx = ctx;
    }

    @Override
    public final World getWorld() {
        return ctx.getWorld();
    }

    @Override
    public final Position getPosition() {
        return ctx.getPosition();
    }

    @Override
    public final Type<?> getType() {
        return type;
    }

    @Override
    public final void save() {
        ctx.save();
    }

    public <X> Mono<X> getComponent(Component<X> component, Mono<Direction> side) {
        return Mono.empty();
    }
}
