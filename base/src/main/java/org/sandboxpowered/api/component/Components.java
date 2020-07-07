package org.sandboxpowered.api.component;

import org.sandboxpowered.internal.InternalService;

public class Components {
    public static final Component<Inventory> INVENTORY_COMPONENT = get(Inventory.class);
    public static final Component<FluidContainer> FLUID_COMPONENT = get(FluidContainer.class);

    private static <X> Component<X> get(Class<X> xClass) {
        return InternalService.getInstance().componentFunction(xClass);
    }
}