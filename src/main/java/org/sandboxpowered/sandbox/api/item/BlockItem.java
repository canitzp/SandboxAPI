package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.block.Block;

public interface BlockItem extends Item {
    Block asBlock();
}
