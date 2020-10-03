package org.sandboxpowered.api.state;

import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.SlabType;
import org.sandboxpowered.internal.InternalService;

public class Properties {
    public static final Property<Boolean> ATTACHED = getProperty("attached");
    public static final Property<Boolean> BOTTOM = getProperty("bottom");
    public static final Property<Boolean> CONDITIONAL = getProperty("conditional");
    public static final Property<Boolean> DISARMED = getProperty("disarmed");
    public static final Property<Boolean> DRAG = getProperty("drag");
    public static final Property<Boolean> ENABLED = getProperty("enabled");
    public static final Property<Boolean> EXTENDED = getProperty("extended");
    public static final Property<Boolean> EYE = getProperty("eye");
    public static final Property<Boolean> FALLING = getProperty("falling");
    public static final Property<Boolean> HANGING = getProperty("hanging");
    public static final Property<Boolean> HAS_BOTTLE_0 = getProperty("has_bottle_0");
    public static final Property<Boolean> HAS_BOTTLE_1 = getProperty("has_bottle_1");
    public static final Property<Boolean> HAS_BOTTLE_2 = getProperty("has_bottle_2");
    public static final Property<Boolean> HAS_RECORD = getProperty("has_record");
    public static final Property<Boolean> HAS_BOOK = getProperty("has_book");
    public static final Property<Boolean> INVERTED = getProperty("inverted");
    public static final Property<Boolean> IN_WALL = getProperty("in_wall");
    public static final Property<Boolean> LIT = getProperty("lit");
    public static final Property<Boolean> LOCKED = getProperty("locked");
    public static final Property<Boolean> OCCUPIED = getProperty("occupied");
    public static final Property<Boolean> OPEN = getProperty("open");
    public static final Property<Boolean> PERSISTENT = getProperty("persistent");
    public static final Property<Boolean> POWERED = getProperty("powered");
    public static final Property<Boolean> SHORT = getProperty("short");
    public static final Property<Boolean> SIGNAL_FIRE = getProperty("signal_fire");
    public static final Property<Boolean> SNOWY = getProperty("snowy");
    public static final Property<Boolean> TRIGGERED = getProperty("triggered");
    public static final Property<Boolean> UNSTABLE = getProperty("unstable");
    public static final Property<Boolean> WATERLOGGED = getProperty("waterlogged");
    public static final Property<Boolean> UP = getProperty("up");
    public static final Property<Boolean> DOWN = getProperty("down");
    public static final Property<Boolean> NORTH = getProperty("north");
    public static final Property<Boolean> EAST = getProperty("east");
    public static final Property<Boolean> SOUTH = getProperty("south");
    public static final Property<Boolean> WEST = getProperty("west");
    public static final Property<Integer> FLUID_LEVEL = getProperty("fluidlevel");
    public static final Property<Integer> AGE_1 = getProperty("age_1");
    public static final Property<Integer> AGE_2 = getProperty("age_2");
    public static final Property<Integer> AGE_3 = getProperty("age_3");
    public static final Property<Integer> AGE_5 = getProperty("age_5");
    public static final Property<Integer> AGE_7 = getProperty("age_7");
    public static final Property<Integer> AGE_15 = getProperty("age_15");
    public static final Property<Integer> AGE_25 = getProperty("age_25");
    public static final Property<Integer> BITES = getProperty("bites");
    public static final Property<Integer> DELAY = getProperty("delay");
    public static final Property<Integer> DISTANCE_1_7 = getProperty("distance_1_7");
    public static final Property<Integer> EGGS = getProperty("eggs");
    public static final Property<Integer> HATCH = getProperty("hatch");
    public static final Property<Integer> LAYERS = getProperty("layers");
    public static final Property<Integer> LEVEL_3 = getProperty("level_3");
    public static final Property<Integer> LEVEL_8 = getProperty("level_8");
    public static final Property<Integer> LEVEL_1_8 = getProperty("level_1_8");
    public static final Property<Integer> FLUID_BLOCK_LEVEL = getProperty("level_15");
    public static final Property<Integer> HONEY_LEVEL = getProperty("honey_level");
    public static final Property<Integer> LEVEL_15 = getProperty("level_15");
    public static final Property<Integer> MOISTURE = getProperty("moisture");
    public static final Property<Integer> NOTE = getProperty("note");
    public static final Property<Integer> PICKLES = getProperty("pickles");
    public static final Property<Integer> POWER = getProperty("power");
    public static final Property<Integer> STAGE = getProperty("stage");
    public static final Property<Integer> DISTANCE_0_7 = getProperty("distance_0_7");
    public static final Property<Integer> ROTATION = getProperty("rotation");
    public static final Property<Direction> FACING = getProperty("facing");
    public static final Property<Direction> HORIZONTAL_FACING = getProperty("horizontal_facing");
    public static final Property<Direction> HOPPER_FACING = getProperty("hopper_facing");
    public static final Property<Direction.Axis> HORIZONTAL_AXIS = getProperty("horizontal_axis");
    public static final Property<Direction.Axis> AXIS = getProperty("axis");
    public static final Property<SlabType> SLAB_TYPE = getProperty("slab_type");

    private static <X extends Comparable<X>> Property<X> getProperty(String s) {
        Property<X> property = InternalService.getInstance().getProperty(s);
        if (property == null)
            throw new NullPointerException("Property cannot be null");
        return property;
    }
}