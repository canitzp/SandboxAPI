package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.util.annotation.Alpha;

@Alpha
public interface LivingEntity extends Entity {
    float getHealth();

    void setHealth(float health);
}
