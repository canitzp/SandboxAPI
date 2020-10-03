package org.sandboxpowered.api.util.math;

public interface Vec3d {
    double getX();

    double getY();

    double getZ();

    Vec3d normalize();

    Vec3d add(double x, double y, double z);
}
