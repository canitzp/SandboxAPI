package org.sandboxpowered.api.client;

public enum GraphicsMode {
    FAST,
    FANCY,
    FABULOUS;

    public boolean isFancyOrBetter() {
        return ordinal() > 0;
    }
}