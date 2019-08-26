package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.block.IBlock;

public interface IBlockItem extends IItem {
    IBlock asBlock();
}
