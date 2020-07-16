package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.ItemEntity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.events.args.*;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.PriorityEventHandler;
import org.sandboxpowered.eventhandler.priority.PriorityHandler;

public class ItemEvents {
    public static final PriorityHandler<PlayerEntity, ArrowTypeArgs> GET_ARROW_TYPE = new PriorityEventHandler<>();
    public static final PriorityHandler<PlayerEntity, ItemArgs> DAMAGE = new PriorityEventHandler<>();
    public static final PriorityHandler<PlayerEntity, EntityArgs<ItemEntity>> THROW = new PriorityEventHandler<>();

}
