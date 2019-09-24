package com.hrznstudio.sandbox.api.entity;

import com.google.common.annotations.Beta;

@Beta
public interface ILivingEntity extends IEntity {
    float getHealth();

    void setHealth(float health);
}
