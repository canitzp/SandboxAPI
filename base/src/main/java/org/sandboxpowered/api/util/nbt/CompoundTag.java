package org.sandboxpowered.api.util.nbt;

import org.sandboxpowered.api.util.Functions;

public interface CompoundTag extends Tag, ReadableCompoundTag, WritableCompoundTag {
    static CompoundTag create() {
        return Functions.getInstance().createCompoundTag();
    }
}