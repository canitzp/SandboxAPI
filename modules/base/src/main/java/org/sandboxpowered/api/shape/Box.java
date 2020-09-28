package org.sandboxpowered.api.shape;

import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.internal.InternalService;

public interface Box {
    static Box of(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        return of(minX / 16d, minY / 16d, minZ / 16d, maxX / 16d, maxY / 16d, maxZ / 16d);
    }

    static Box of(Position pos1, Position pos2) {
        return InternalService.getInstance().box_of(pos1, pos2);
    }

    static Box of(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return InternalService.getInstance().box_of(minX, minY, minZ, maxX, maxY, maxZ);
    }
}