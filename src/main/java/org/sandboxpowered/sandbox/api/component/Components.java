package org.sandboxpowered.sandbox.api.component;

import org.sandboxpowered.sandbox.api.util.Functions;

public class Components {
    public static final Component<Inventory> INVENTORY_COMPONENT = get(Inventory.class);
    public static final Component<FluidContainer> FLUID_COMPONENT = get(FluidContainer.class);

    private static <X> Component<X> get(Class<X> xClass) {
        return Functions.getInstance().componentFunction(xClass);
    }
}