package com.hrznstudio.sandbox.api.util.math;

import com.hrznstudio.sandbox.api.util.Direction;

public interface Position extends Vec3i {
    Mutable toMutable();

    Position toImmutable();

    default Position offset(Direction direction) {
        return offset(direction, 1);
    }

    Position offset(Direction direction, int amount);

    interface Mutable extends Position {

        default Mutable setX(int x) {
            return set(x, getY(), getZ());
        }

        default Mutable setY(int y) {
            return set(getX(), y, getZ());
        }

        default Mutable setZ(int z) {
            return set(getX(), getY(), z);
        }

        Mutable set(int x, int y, int z);
    }
}