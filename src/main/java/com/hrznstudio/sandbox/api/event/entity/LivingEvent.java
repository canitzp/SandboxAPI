package com.hrznstudio.sandbox.api.event.entity;

import com.hrznstudio.sandbox.api.entity.ILivingEntity;

public class LivingEvent extends EntityEvent {
    private final ILivingEntity entity;

    public LivingEvent(ILivingEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public ILivingEntity getEntity() {
        return entity;
    }

    @Cancellable
    public static class Death extends LivingEvent {
        public Death(ILivingEntity entity) {
            super(entity);
        }
    }
}