package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.eventhandler.core.EventArgs;

public interface CopyDataArgs extends EventArgs {
    PlayerEntity getPlayer();

    boolean isGameEnding();
}
