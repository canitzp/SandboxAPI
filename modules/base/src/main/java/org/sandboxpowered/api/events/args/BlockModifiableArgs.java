package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.state.BlockState;

public interface BlockModifiableArgs extends BlockArgs {
    void setState(BlockState state);
}
