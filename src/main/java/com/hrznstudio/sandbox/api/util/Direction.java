package com.hrznstudio.sandbox.api.util;

import com.google.common.collect.Iterators;
import com.hrznstudio.sandbox.api.util.math.Vec3i;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Direction {
    DOWN(0, 1, -1, "down", Direction.AxisDirection.NEGATIVE, Direction.Axis.Y, Vec3i.create(0, -1, 0)),
    UP(1, 0, -1, "up", Direction.AxisDirection.POSITIVE, Direction.Axis.Y, Vec3i.create(0, 1, 0)),
    NORTH(2, 3, 2, "north", Direction.AxisDirection.NEGATIVE, Direction.Axis.Z, Vec3i.create(0, 0, -1)),
    SOUTH(3, 2, 0, "south", Direction.AxisDirection.POSITIVE, Direction.Axis.Z, Vec3i.create(0, 0, 1)),
    WEST(4, 5, 1, "west", Direction.AxisDirection.NEGATIVE, Direction.Axis.X, Vec3i.create(-1, 0, 0)),
    EAST(5, 4, 3, "east", Direction.AxisDirection.POSITIVE, Direction.Axis.X, Vec3i.create(1, 0, 0));
    private static final Direction[] ALL = values();
    private static final Map<String, Direction> NAME_MAP = Arrays.stream(ALL).collect(Collectors.toMap(Direction::getName, (dir) -> dir));
    private static final Direction[] ID_TO_DIRECTION = Arrays.stream(ALL).sorted(Comparator.comparingInt((direction_1) -> direction_1.id)).toArray(Direction[]::new);
    private static final Direction[] HORIZONTAL = Arrays.stream(ALL).filter((direction_1) -> direction_1.getAxis().isHorizontal()).sorted(Comparator.comparingInt((direction_1) -> direction_1.horizontalId)).toArray(Direction[]::new);
    private final int id;
    private final int invertedId;
    private final int horizontalId;
    private final String name;
    private final Direction.Axis axis;
    private final Direction.AxisDirection direction;
    private final Vec3i vector;

    Direction(int id, int horizontalId, int invertedId, String name, Direction.AxisDirection direction, Direction.Axis axis, Vec3i vector) {
        this.id = id;
        this.horizontalId = horizontalId;
        this.invertedId = invertedId;
        this.name = name;
        this.axis = axis;
        this.direction = direction;
        this.vector = vector;
    }

    @Nullable
    public static Direction byName(@Nullable String string_1) {
        return string_1 == null ? null : NAME_MAP.get(string_1.toLowerCase(Locale.ROOT));
    }

    public static Direction byId(int int_1) {
        return ID_TO_DIRECTION[Math.abs(int_1 % ID_TO_DIRECTION.length)];
    }

    public static Direction fromHorizontal(int int_1) {
        return HORIZONTAL[Math.abs(int_1 % HORIZONTAL.length)];
    }

    public static Direction fromRotation(double double_1) {
        return fromHorizontal((int) Math.floor(double_1 / 90.0D + 0.5D) & 3);
    }

    public static Direction from(Direction.Axis axis, Direction.AxisDirection direction) {
        switch (axis) {
            case X:
                return direction == Direction.AxisDirection.POSITIVE ? EAST : WEST;
            case Y:
                return direction == Direction.AxisDirection.POSITIVE ? UP : DOWN;
            case Z:
            default:
                return direction == Direction.AxisDirection.POSITIVE ? SOUTH : NORTH;
        }
    }

    public static Direction getFacing(double x, double y, double z) {
        return getFacing((float) x, (float) y, (float) z);
    }

    public static Direction getFacing(float x, float y, float z) {
        Direction outDir = NORTH;
        float val = Float.MIN_VALUE;

        for (Direction dir : ALL) {
            float float_5 = x * (float) dir.vector.getX() + y * (float) dir.vector.getY() + z * (float) dir.vector.getZ();
            if (float_5 > val) {
                val = float_5;
                outDir = dir;
            }
        }

        return outDir;
    }

    public static Direction get(Direction.AxisDirection direction, Direction.Axis axis) {
        for (Direction direction_1 : values()) {
            if (direction_1.getDirection() == direction && direction_1.getAxis() == axis) {
                return direction_1;
            }
        }

        throw new IllegalArgumentException("No such direction: " + direction + " " + axis);
    }

    public int getId() {
        return this.id;
    }

    public int getHorizontalId() {
        return this.horizontalId;
    }

    public Direction.AxisDirection getDirection() {
        return this.direction;
    }

    public Direction getOppositeDirection() {
        return byId(this.invertedId);
    }

    public Direction rotateClockwise(Direction.Axis axis) {
        switch (axis) {
            case X:
                if (this != WEST && this != EAST) {
                    return this.rotateXClockwise();
                }
                return this;
            case Y:
                if (this != UP && this != DOWN) {
                    return this.rotateYClockwise();
                }
                return this;
            case Z:
                if (this != NORTH && this != SOUTH) {
                    return this.rotateZClockwise();
                }
                return this;
            default:
                throw new IllegalStateException("Unable to get clockwise facing for axis " + axis);
        }
    }

    public Direction rotateYClockwise() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
        }
    }

    private Direction rotateXClockwise() {
        switch (this) {
            case NORTH:
                return DOWN;
            case EAST:
            case WEST:
            default:
                throw new IllegalStateException("Unable to get X-rotated facing of " + this);
            case SOUTH:
                return UP;
            case UP:
                return NORTH;
            case DOWN:
                return SOUTH;
        }
    }

    private Direction rotateZClockwise() {
        switch (this) {
            case EAST:
                return DOWN;
            case SOUTH:
            default:
                throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
            case WEST:
                return UP;
            case UP:
                return EAST;
            case DOWN:
                return WEST;
        }
    }

    public Direction rotateYCounterClockwise() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("Unable to get CounterClockwise facing of " + this);
        }
    }

    public int getOffsetX() {
        return this.axis == Direction.Axis.X ? this.direction.offset() : 0;
    }

    public int getOffsetY() {
        return this.axis == Direction.Axis.Y ? this.direction.offset() : 0;
    }

    public int getOffsetZ() {
        return this.axis == Direction.Axis.Z ? this.direction.offset() : 0;
    }

    public String getName() {
        return this.name;
    }

    public Direction.Axis getAxis() {
        return this.axis;
    }

    public float asRotation() {
        return (float) ((this.horizontalId & 3) * 90);
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }

    public Vec3i getVector() {
        return this.vector;
    }

    public enum Type implements Predicate<Direction>, Iterable<Direction> {
        HORIZONTAL(new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST}, new Direction.Axis[]{Direction.Axis.X, Direction.Axis.Z}),
        VERTICAL(new Direction[]{Direction.UP, Direction.DOWN}, new Direction.Axis[]{Direction.Axis.Y});

        private final Direction[] facingArray;
        private final Direction.Axis[] axisArray;

        Type(Direction[] directions, Direction.Axis[] axes) {
            this.facingArray = directions;
            this.axisArray = axes;
        }


        @Override
        public boolean test(@Nullable Direction direction) {
            return direction != null && direction.getAxis().getType() == this;
        }

        @Override
        @Nonnull
        public Iterator<Direction> iterator() {
            return Iterators.forArray(facingArray);
        }
    }

    public enum AxisDirection {
        POSITIVE(1, "Towards positive"),
        NEGATIVE(-1, "Towards negative");

        private final int offset;
        private final String description;

        AxisDirection(int offset, String description) {
            this.offset = offset;
            this.description = description;
        }

        public int offset() {
            return this.offset;
        }

        public String toString() {
            return this.description;
        }
    }

    public enum Axis implements Predicate<Direction> {
        X("x") {
            public int choose(int x, int y, int z) {
                return z;
            }

            public double choose(double x, double y, double z) {
                return x;
            }
        },
        Y("y") {
            public int choose(int x, int y, int z) {
                return y;
            }

            public double choose(double x, double y, double z) {
                return y;
            }
        },
        Z("z") {
            public int choose(int x, int y, int z) {
                return z;
            }

            public double choose(double x, double y, double z) {
                return z;
            }
        };

        private static final Map<String, Direction.Axis> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(Axis::getName, (axis) -> axis));
        private final String name;

        Axis(String string_1) {
            this.name = string_1;
        }

        @Nullable
        public static Direction.Axis fromName(String string_1) {
            return BY_NAME.get(string_1.toLowerCase(Locale.ROOT));
        }

        public String getName() {
            return this.name;
        }

        public boolean isVertical() {
            return this == Y;
        }

        public boolean isHorizontal() {
            return this == X || this == Z;
        }

        public String toString() {
            return this.name;
        }

        @Override
        public boolean test(@Nullable Direction direction) {
            return direction != null && direction.getAxis() == this;
        }

        public Direction.Type getType() {
            switch (this) {
                case X:
                case Z:
                    return Direction.Type.HORIZONTAL;
                case Y:
                    return Direction.Type.VERTICAL;
                default:
                    throw new Error("Someone's been tampering with the universe!");
            }
        }

        public String asString() {
            return this.name;
        }

        public abstract int choose(int x, int y, int z);

        public abstract double choose(double x, double y, double z);
    }

}