package org.sandboxpowered.api.block.multipart;

import org.sandboxpowered.api.util.Identity;

import java.util.HashMap;
import java.util.Map;

public final class Slot {
    private static final Map<Identity, Slot> SLOT_MAP = new HashMap<>();
    public static final Slot BLOCK = get(Identity.of("sandbox", "block"));

    private final Identity identity;

    public Slot(Identity identity) {
        this.identity = identity;
    }

    public static Slot get(Identity id) {
        return SLOT_MAP.computeIfAbsent(id, Slot::new);
    }

    public Identity getIdentity() {
        return identity;
    }
}