package org.sandboxpowered.sandbox.api.state;

import org.sandboxpowered.sandbox.api.util.Functions;

public class Properties {
    public static final Property<Boolean> ATTACHED = get("attached");
    public static final Property<Boolean> BOTTOM = get("bottom");
    public static final Property<Boolean> CONDITIONAL = get("conditional");
    public static final Property<Boolean> DISARMED = get("disarmed");
    public static final Property<Boolean> DRAG = get("drag");
    public static final Property<Boolean> ENABLED = get("enabled");
    public static final Property<Boolean> EXTENDED = get("extended");
    public static final Property<Boolean> EYE = get("eye");
    public static final Property<Boolean> FALLING = get("falling");
    public static final Property<Boolean> HANGING = get("hanging");
    public static final Property<Boolean> HAS_BOTTLE_0 = get("has_bottle_0");
    public static final Property<Boolean> HAS_BOTTLE_1 = get("has_bottle_1");
    public static final Property<Boolean> HAS_BOTTLE_2 = get("has_bottle_2");
    public static final Property<Boolean> HAS_RECORD = get("has_record");
    public static final Property<Boolean> HAS_BOOK = get("has_book");
    public static final Property<Boolean> INVERTED = get("inverted");
    public static final Property<Boolean> IN_WALL = get("in_wall");
    public static final Property<Boolean> LIT = get("lit");
    public static final Property<Boolean> LOCKED = get("locked");
    public static final Property<Boolean> OCCUPIED = get("occupied");
    public static final Property<Boolean> OPEN = get("open");
    public static final Property<Boolean> PERSISTENT = get("persistent");
    public static final Property<Boolean> POWERED = get("powered");
    public static final Property<Boolean> SHORT = get("short");
    public static final Property<Boolean> SIGNAL_FIRE = get("signal_fire");
    public static final Property<Boolean> SNOWY = get("snowy");
    public static final Property<Boolean> TRIGGERED = get("triggered");
    public static final Property<Boolean> UNSTABLE = get("unstable");
    public static final Property<Boolean> WATERLOGGED = get("waterlogged");
    public static final Property<Integer> FLUID_LEVEL = get("fluidlevel");
    public static final Property<Integer> FLUID_BLOCK_LEVEL = get("level_15");

    private static <X extends Comparable<X>> Property<X> get(String s) {
        Property<X> property = Functions.getInstance().getProperty(s);
        if (property == null)
            throw new NullPointerException("Property cannot be null");
        return property;
    }
}