package org.sandboxpowered.sandbox.api.event.entity;

import org.sandboxpowered.sandbox.api.entity.LivingEntity;

public class LivingEvent extends EntityEvent {
    private final LivingEntity entity;

    public LivingEvent(LivingEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public LivingEntity getEntity() {
        return entity;
    }

    @Cancellable
    public static class Death extends LivingEvent {
        public Death(LivingEntity entity) {
            super(entity);
        }
    }
}