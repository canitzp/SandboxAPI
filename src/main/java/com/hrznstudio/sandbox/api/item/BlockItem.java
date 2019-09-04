package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.block.Block;
import com.hrznstudio.sandbox.api.block.IBlock;

public class BlockItem extends Item implements IBlockItem {
    private final Block block;

    public BlockItem(Block block) {
        super(new Settings());
        this.block = block;
    }

    @Override
    public IBlock asBlock() {
        return block;
    }
}