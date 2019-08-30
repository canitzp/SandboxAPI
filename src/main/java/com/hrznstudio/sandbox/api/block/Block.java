package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.block.state.StateFactory;
import com.hrznstudio.sandbox.api.item.IItem;

public abstract class Block implements IBlock {
    private Object wrapped;
    private IItem itemCache;
    private StateFactory<IBlock, BlockState> stateFactory;
    private final Properties properties;

    public Block(Properties properties) {
        this.properties = properties;
    }

    @Override
    public final Properties getProperties() {
        return properties;
    }

    @Override
    public StateFactory<IBlock, BlockState> getStateFactory() {
        return stateFactory;
    }

    public final void setStateFactory(StateFactory<IBlock, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public final Object getWrapped() {
        return wrapped;
    }

    public final void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public IItem asItem() {
        if (itemCache == null) {
            itemCache = Registries.ITEM.get(Registries.BLOCK.getIdentity(this));
        }
        return itemCache;
    }

    @Override
    public final BlockState getBaseState() {
        return stateFactory.getBaseState();
    }
}