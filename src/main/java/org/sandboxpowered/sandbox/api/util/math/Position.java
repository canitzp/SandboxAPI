package org.sandboxpowered.sandbox.api.util.math;

import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Functions;

import javax.annotation.concurrent.Immutable;

@Immutable
public interface Position extends Vec3i {
    Position ZERO = create(0, 0, 0);

    static Position create(int x, int y, int z) {
        return Functions.positionFunction.apply(new int[]{x, y, z});
    }

    static Position create(Vec3i vec3i) {
        return create(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    Mutable toMutable();

    Position toImmutable();

    default Position offset(Direction direction) {
        return offset(direction, 1);
    }

    Position offset(Direction direction, int amount);

    default Position up() {
        return up(1);
    }

    default Position up(int amount) {
        return offset(Direction.UP, amount);
    }

    default Position down() {
        return down(1);
    }

    default Position down(int amount) {
        return offset(Direction.DOWN, amount);
    }

    default Position north() {
        return north(1);
    }

    default Position north(int amount) {
        return offset(Direction.NORTH, amount);
    }

    default Position south() {
        return south(1);
    }

    default Position south(int amount) {
        return offset(Direction.SOUTH, amount);
    }

    default Position east() {
        return east(1);
    }

    default Position east(int amount) {
        return offset(Direction.EAST, amount);
    }

    default Position west() {
        return west(1);
    }

    default Position west(int amount) {
        return offset(Direction.WEST, amount);
    }

    interface Mutable extends Position {

        static Mutable create() {
            return create(0, 0, 0);
        }

        static Mutable create(int x, int y, int z) {
            return Functions.mutablePositionFunction.apply(new int[]{x, y, z});
        }

        static Mutable create(Vec3i vec3i) {
            return create(vec3i.getX(), vec3i.getY(), vec3i.getZ());
        }

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

        default Mutable set(Vec3i vec) {
            return set(vec.getX(), vec.getY(), vec.getZ());
        }
    }
}