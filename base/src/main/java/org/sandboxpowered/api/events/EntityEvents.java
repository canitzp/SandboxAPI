package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.ItemEntity;
import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.events.args.*;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.PriorityEventHandler;
import org.sandboxpowered.eventhandler.core.EventArgs;
import org.sandboxpowered.eventhandler.core.EventHandlerBase;
import org.sandboxpowered.eventhandler.priority.Cancellable;
import org.sandboxpowered.eventhandler.priority.PriorityHandler;

public class EntityEvents {
    public static final PriorityHandler<Entity, Cancellable> SPAWN = new PriorityEventHandler<>();
    public static final PriorityHandler<Entity, Cancellable> TICK = new PriorityEventHandler<>();
    public static final PriorityHandler<Entity, Cancellable> DEATH = new PriorityEventHandler<>();
    public static final PriorityHandler<Entity, Cancellable> REMOVE = new PriorityEventHandler<>();
    public static final PriorityHandler<Entity, SizeUpdateArgs> UPDATE_SIZE = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, DropsArgs> DROPS = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, HealthArgs> HURT = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, HealthArgs> HEAL = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, DistanceArgs> FALL = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, Cancellable> JUMP = new PriorityEventHandler<>();
    public static final PriorityHandler<LivingEntity, EntityArgs<LivingEntity>> KNOCKBACK = new PriorityEventHandler<>();
    public static final EventHandlerBase<Entity, EventArgs> CONSTRUCT = new EventHandler<>();

    //TODO may need args that include the renderer
    public static final PriorityHandler<Entity, Cancellable> RENDER = new PriorityEventHandler<>();
}
