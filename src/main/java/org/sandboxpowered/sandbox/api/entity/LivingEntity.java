package org.sandboxpowered.sandbox.api.entity;

import com.google.common.annotations.Beta;

@Beta
public interface LivingEntity extends Entity {
    float getHealth();

    void setHealth(float health);
}
