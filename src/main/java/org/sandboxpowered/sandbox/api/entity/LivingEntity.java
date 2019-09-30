package org.sandboxpowered.sandbox.api.entity;

import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface LivingEntity extends Entity {
    float getHealth();

    void setHealth(float health);
}
