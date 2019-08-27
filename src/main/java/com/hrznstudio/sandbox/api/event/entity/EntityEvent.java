package com.hrznstudio.sandbox.api.event.entity;

import com.hrznstudio.sandbox.api.entity.IEntity;
import com.hrznstudio.sandbox.api.event.Event;

public class EntityEvent extends Event {
    private final IEntity entity;

    public EntityEvent(IEntity entity) {
        this.entity = entity;
    }

    public IEntity getEntity() {
        return entity;
    }

}
