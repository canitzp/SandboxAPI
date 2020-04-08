package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class Fluids {
    public static final Registry.Entry<Fluid> EMPTY = get("empty");
    public static final Registry.Entry<Fluid> WATER = get("water");
    public static final Registry.Entry<Fluid> LAVA = get("lava");
    public static final Registry.Entry<Fluid> WATER_FLOWING = get("flowing_water");
    public static final Registry.Entry<Fluid> LAVA_FLOWING = get("flowing_lava");

    private static Registry.Entry<Fluid> get(String name) {
        return Fluid.REGISTRY.get(Identity.of("minecraft", name));
    }
}
