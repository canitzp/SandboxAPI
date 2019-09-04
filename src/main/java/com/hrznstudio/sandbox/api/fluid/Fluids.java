package com.hrznstudio.sandbox.api.fluid;

import com.hrznstudio.sandbox.api.util.Functions;

public class Fluids {
    public static final IFluid EMPTY = get("empty");
    public static final IFluid WATER = get("water");
    public static final IFluid LAVA = get("lava");
    public static final IFluid WATER_FLOWING = get("flowing_water");
    public static final IFluid LAVA_FLOWING = get("flowing_lava");

    private static IFluid get(String name) {
        IFluid fluid = Functions.fluidFunction.apply(name);
        if (fluid == null)
            throw new RuntimeException("Unknown Fluid " + name);
        return fluid;
    }
}
