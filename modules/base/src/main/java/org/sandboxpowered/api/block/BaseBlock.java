package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.component.Components;
import org.sandboxpowered.api.component.fluid.FluidLoggingContainer;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.Properties;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.WorldReader;

import java.util.Optional;

public class BaseBlock implements Block {
    private final Settings settings;
    private Registry.Entry<Item> itemCache;
    private StateFactory<Block, BlockState> stateFactory;
    private BlockState baseState;

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
        this.baseState = createBaseState(stateFactory.getBaseState());
    }

    protected BlockState createBaseState(BlockState baseState) {
        return baseState;
    }

    @Override
    public Optional<Item> asItem() {
        if (itemCache == null) {
            itemCache = Item.REGISTRY.get(getIdentity());
        }
        return itemCache.getAsOptional();
    }

    @Override
    public final <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component) {
        return getComponent(world, position, state, component, null);
    }

    @Override
    public <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, @Nullable Direction side) {
        if (this instanceof FluidLoggable && component == Components.FLUID_COMPONENT) {
            return Mono.of(new FluidLoggingContainer((FluidLoggable) this, world, position, state, side)).cast();
        } else if (hasBlockEntity()) {
            BlockEntity entity = world.getBlockEntity(position);
            if (entity != null)
                return entity.getComponent(component, side);
        }
        return Mono.empty();
    }

    public void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        if (this instanceof FluidLoggable && ((FluidLoggable) this).needsWaterloggedProperty()) {
            builder.add(Properties.WATERLOGGED);
        }
    }

    @Override
    public final BlockState getBaseState() {
        return baseState;
    }
}