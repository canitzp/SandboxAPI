package org.sandboxpowered.sandbox.api.fluid;

import org.sandboxpowered.sandbox.api.util.Functions;

public class Fluids {
    public static final Fluid EMPTY = get("empty");
    public static final Fluid WATER = get("water");
    public static final Fluid LAVA = get("lava");
    public static final Fluid WATER_FLOWING = get("flowing_water");
    public static final Fluid LAVA_FLOWING = get("flowing_lava");

    private static Fluid get(String name) {
        Fluid fluid = Functions.fluidFunction.apply(name);
        if (fluid == null)
            throw new RuntimeException("Unknown Fluid " + name);
        return fluid;
    }
}
