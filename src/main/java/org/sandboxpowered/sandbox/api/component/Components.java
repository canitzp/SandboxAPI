package org.sandboxpowered.sandbox.api.component;

import org.sandboxpowered.sandbox.api.util.Functions;

public class Components {
    public static final Component<Inventory> INVENTORY_COMPONENT = get(Inventory.class);

    private static <X> Component<X> get(Class<X> xClass) {
        return Functions.getInstance().componentFunction(xClass);
    }
}