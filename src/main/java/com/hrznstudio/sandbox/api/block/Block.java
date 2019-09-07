package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.state.Properties;
import com.hrznstudio.sandbox.api.state.StateFactory;

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