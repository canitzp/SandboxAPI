package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.events.args.BlockArgs;
import org.sandboxpowered.api.events.args.ChatArgs;
import org.sandboxpowered.api.events.args.EntityArgs;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.PriorityEventHandler;
import org.sandboxpowered.eventhandler.core.EventHandlerBase;
import org.sandboxpowered.eventhandler.priority.PriorityHandler;

public class PlayerEvents {
    public static final PriorityHandler<PlayerEntity, EntityArgs<LivingEntity>> ENTITY_INTERACT = new PriorityEventHandler<>();
    public static final PriorityHandler<PlayerEntity, EntityArgs<LivingEntity>> BLOCK_INTERACT = new PriorityEventHandler<>();
    public static final PriorityHandler<PlayerEntity, BlockArgs> SLEEP = new PriorityEventHandler<>();
    public static final PriorityHandler<PlayerEntity, BlockArgs> WAKE_UP = new PriorityEventHandler<>();
    public static final EventHandlerBase<PlayerEntity, ChatArgs> CHAT_MESSAGE = new EventHandler<>();
    public static final EventHandlerBase<PlayerEntity, EntityArgs<PlayerEntity>> CLONE = new EventHandler<>();
}
