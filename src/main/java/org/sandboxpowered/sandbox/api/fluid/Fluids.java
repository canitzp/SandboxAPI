package org.sandboxpowered.sandbox.api.fluid;

import org.sandboxpowered.sandbox.api.Registries;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Identity;

public class Fluids {
    public static final Registry.Entry<Fluid> EMPTY = get("empty");
    public static final Registry.Entry<Fluid> WATER = get("water");
    public static final Registry.Entry<Fluid> LAVA = get("lava");
    public static final Registry.Entry<Fluid> WATER_FLOWING = get("flowing_water");
    public static final Registry.Entry<Fluid> LAVA_FLOWING = get("flowing_lava");

    private static Registry.Entry<Fluid> get(String name) {
        return Registries.FLUID.get(Identity.of("minecraft", name));
    }
}
