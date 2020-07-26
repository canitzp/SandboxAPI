package org.sandboxpowered.api.util.math;

public interface Matrix3f {
    void invert();

    void multiply(Matrix3f matrix);

    void multiply(Quaternion quaternion);

    void multiply(float scale);

    void loadIdentity();

    Matrix3f copy();
}
