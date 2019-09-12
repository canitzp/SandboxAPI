package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.block.entity.BlockEntity;
import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.state.Properties;
import com.hrznstudio.sandbox.api.state.StateFactory;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.WorldReader;

public abstract class Block implements IBlock {
    private final Settings settings;
    private IItem itemCache;
    private StateFactory<IBlock, BlockState> stateFactory;

    public Block(Settings settings) {
        this.settings = settings;
    }

    @Override
    public final Settings getSettings() {
        return settings;
    }

    @Override
    public final StateFactory<IBlock, BlockState> getStateFactory() {
        return stateFactory;
    }

    public final void setStateFactory(StateFactory<IBlock, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    @Override
    public IItem asItem() {
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
        if (hasBlockEntity()) {
            IBlockEntity entity = world.getBlockEntity(position);
            if (entity instanceof BlockEntity)
                return ((BlockEntity) entity).getComponent(component, side);
        }
        return Mono.empty();
    }

    public void appendProperties(StateFactory.Builder<IBlock, BlockState> builder) {
        if (canContainFluids()) {
            builder.add(Properties.WATERLOGGED);
        }
    }

    @Override
    public final BlockState getBaseState() {
        return stateFactory.getBaseState();
    }
}