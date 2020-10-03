package org.sandboxpowered.api.util.math;

public interface Matrix4f {
    void invert();

    void multiply(Matrix4f matrix);

    void multiply(Quaternion quaternion);

    void multiply(float scale);

    void loadIdentity();

    Matrix4f copy();
}