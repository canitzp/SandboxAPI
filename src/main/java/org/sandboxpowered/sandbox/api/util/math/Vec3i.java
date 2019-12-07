package org.sandboxpowered.sandbox.api.util.math;

import org.sandboxpowered.sandbox.api.util.Functions;

import javax.annotation.concurrent.Immutable;

@Immutable
public interface Vec3i {
    static Vec3i create(int x, int y, int z) {
        return Functions.getInstance().createVec3i(x, y, z);
    }

    int getX();

    int getY();

    int getZ();
}