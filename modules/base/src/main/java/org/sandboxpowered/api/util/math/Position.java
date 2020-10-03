package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.internal.InternalService;
import org.sandboxpowered.internal.PositionIterator;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Position extends Vec3i {
    Position ZERO = create(0, 0, 0);

    static Position create(int x, int y, int z) {
        return InternalService.getInstance().createPosition(x, y, z);
    }

    static Position create(Vec3i vec3i) {
        return create(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    static Stream<Position> getAllWithin(Position start, Position end) {
        return getAllWithin(start.getX(), start.getY(), start.getZ(), end.getX(), end.getY(), end.getZ());
    }

    static Stream<Position> getAllWithin(int x1, int y1, int z1, int x2, int y2, int z2) {
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<Position>((x2 - x1 + 1) * (y2 - y1 + 1) * (z2 - z1 + 1), Spliterator.SIZED | Spliterator.NONNULL) {
            final PositionIterator iterator = new PositionIterator(x1, y1, z1, x2, y2, z2);
            final Mutable mutable = Mutable.create();

            @Override
            public boolean tryAdvance(Consumer<? super Position> action) {
                if (iterator.step()) {
                    action.accept(mutable.set(iterator.getX(), iterator.getY(), iterator.getZ()));
                    return true;
                }
                return false;
            }
        }, false);
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

    Position add(int x, int y, int z);

    Position sub(int x, int y, int z);

    interface Mutable extends Position {

        static Mutable create() {
            return create(0, 0, 0);
        }

        static Mutable create(int x, int y, int z) {
            return InternalService.getInstance().createMutablePosition(x, y, z);
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