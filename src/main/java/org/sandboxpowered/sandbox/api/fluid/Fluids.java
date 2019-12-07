package org.sandboxpowered.sandbox.api.fluid;

import org.sandboxpowered.sandbox.api.Registries;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;

public class Fluids {
    public static final Fluid EMPTY = get("empty");
    public static final Fluid WATER = get("water");
    public static final Fluid LAVA = get("lava");
    public static final Fluid WATER_FLOWING = get("flowing_water");
    public static final Fluid LAVA_FLOWING = get("flowing_lava");

    private static Fluid get(String name) {
        Mono<Fluid> fluid = Registries.FLUID.get(Identity.of("minecraft", name));
        return "empty".equals(name) ? fluid.get() : fluid.orElse(EMPTY);
    }
}
