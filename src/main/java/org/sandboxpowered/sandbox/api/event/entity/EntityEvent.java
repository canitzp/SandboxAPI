package org.sandboxpowered.sandbox.api.event.entity;

import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.event.Event;

public class EntityEvent extends Event {
    private final Entity entity;

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    @Cancellable
    public static class Spawn extends EntityEvent {
        public Spawn(Entity entity) {
            super(entity);
        }
    }
}
