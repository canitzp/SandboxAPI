package org.sandboxpowered.api.util.math;

public interface Quaternion {

    float getX();

    float getY();

    float getZ();

    float getW();

    void normalize();

    void scale(float scale);

    void set(float x, float y, float z, float w);

    void conjugate();

    Quaternion copy();
}