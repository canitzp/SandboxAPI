package org.sandboxpowered.api.util.math;

import org.sandboxpowered.internal.InternalService;

public interface Vec3i {
    static Vec3i create(int x, int y, int z) {
        return InternalService.getInstance().createVec3i(x, y, z);
    }

    int getX();

    int getY();

    int getZ();
}