package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.block.BaseBlock;
import org.sandboxpowered.sandbox.api.block.Block;

public class BaseBlockItem extends BaseItem implements BlockItem {
    private final BaseBlock block;

    public BaseBlockItem(BaseBlock block, Settings settings) {
        super(settings);
        this.block = block;
    }

    @Override
    public Block asBlock() {
        return block;
    }
}