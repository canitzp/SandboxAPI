package org.sandboxpowered.api.util.math;

public interface MatrixStack {
    void push();

    void scale(double x, double y, double z);

    void scale(float x, float y, float z);

    void scale(Vec3f vec);

    void scale(Vec3d vec);

    void translate(double x, double y, double z);

    void translate(float x, float y, float z);

    void translate(Vec3d vec);

    void translate(Vec3f vec);

    Entry peek();

    boolean isEmpty();

    void pop();

    interface Entry {
        Matrix4f getModelMatrix();

        Matrix3f getNormalMatrix();
    }
}
