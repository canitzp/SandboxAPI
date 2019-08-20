package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.block.state.StateFactory;
import com.hrznstudio.sandbox.api.item.IItem;

public abstract class Block implements IBlock {
    private Object wrapped;
    private StateFactory<IBlock, BlockState> stateFactory;

    @Override
    public StateFactory<IBlock, BlockState> getStateFactory() {
        return stateFactory;
    }

    public void setStateFactory(StateFactory<IBlock, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public Object getWrapped() {
        return wrapped;
    }

    public void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public IItem asItem() {
        return Registries.ITEM.get(Registries.BLOCK.getIdentity(this));
    }

    @Override
    public BlockState getBaseState() {
        return stateFactory.getBaseState();
    }
}