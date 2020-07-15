package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.events.args.BlockArgs;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.PriorityEventHandler;
import org.sandboxpowered.eventhandler.priority.PriorityHandler;

public class BlockEvents {
    public static final PriorityHandler<PlayerEntity, BlockArgs> BREAK = new PriorityEventHandler<>();

    //Render highlight, might need more info in the args than the standard block info
    public static final PriorityHandler<World, BlockArgs> HIGHLIGHT = new PriorityEventHandler<>();
}
