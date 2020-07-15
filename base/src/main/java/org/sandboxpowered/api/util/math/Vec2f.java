package org.sandboxpowered.api.util.math;

public interface Vec2f {
    float getX();

    float getY();

    Vec2f normalize();

    Vec2f add(float x, float y);
}
