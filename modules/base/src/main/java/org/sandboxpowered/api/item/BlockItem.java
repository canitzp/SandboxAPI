package org.sandboxpowered.api.item;

import org.sandboxpowered.api.block.Block;

public interface BlockItem extends Item {
    Block asBlock();
}
