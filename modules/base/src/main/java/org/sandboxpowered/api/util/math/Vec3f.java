package org.sandboxpowered.api.util.math;

public interface Vec3f {
    float getX();

    float getY();

    float getZ();

    Vec3f normalize();

    Vec3f add(float x, float y, float z);
}
