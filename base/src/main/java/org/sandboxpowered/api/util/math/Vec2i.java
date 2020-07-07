package org.sandboxpowered.api.util.math;

import org.sandboxpowered.internal.InternalService;

public interface Vec2i {
    static Vec2i create(int x, int y) {
        return InternalService.getInstance().createVec2i(x, y);
    }

    int getX();

    int getY();
}