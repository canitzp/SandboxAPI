package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface BlockArgs extends Cancellable {
    Position getPosition();
    BlockState getState();
    default Block getBlock() {
        return getState().getBlock();
    }
}
