package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.Registries;
import org.sandboxpowered.sandbox.api.block.entity.BaseBlockEntity;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.component.Components;
import org.sandboxpowered.sandbox.api.component.fluid.FluidLoggingContainer;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Internal;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public class BaseBlock implements Block {
    private final Settings settings;
    private Mono<Item> itemCache;
    private StateFactory<Block, BlockState> stateFactory;

    public BaseBlock(Settings settings) {
        this.settings = settings;
    }

    @Override
    public final Settings getSettings() {
        return settings;
    }

    @Override
    public final StateFactory<Block, BlockState> getStateFactory() {
        return stateFactory;
    }

    @Internal
    public final void setStateFactory(StateFactory<Block, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    @Override
    public Mono<Item> asItem() {
        if (itemCache == null) {
            itemCache = Registries.ITEM.get(Registries.BLOCK.getIdentity(this));
        }
        return itemCache;
    }

    @Override
    public final <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component) {
        return getComponent(world, position, state, component, Mono.empty());
    }

    @Override
    public final <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Direction side) {
        return getComponent(world, position, state, component, Mono.of(side));
    }

    @Override
    public <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Mono<Direction> side) {
        if (this instanceof FluidLoggable && component == Components.FLUID_COMPONENT) {
            return Mono.of(new FluidLoggingContainer((FluidLoggable) this, world, position, state, side)).cast();
        } else if (hasBlockEntity()) {
            BlockEntity entity = world.getBlockEntity(position);
            if (entity instanceof BaseBlockEntity)
                return ((BaseBlockEntity) entity).getComponent(component, side);
        }
        return Mono.empty();
    }

    public void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        if (this instanceof FluidLoggable && ((FluidLoggable)this).needsWaterloggedProperty()) {
            builder.add(Properties.WATERLOGGED);
        }
    }

    @Override
    public final BlockState getBaseState() {
        return stateFactory.getBaseState();
    }
}