package org.sandboxpowered.sandbox.api.util.nbt;

import org.sandboxpowered.sandbox.api.util.Functions;

public interface CompoundTag extends Tag, ReadableCompoundTag, WritableCompoundTag {
    static CompoundTag create() {
        return Functions.getInstance().createCompoundTag();
    }
}