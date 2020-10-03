package org.sandboxpowered.api.util.nbt;

import org.sandboxpowered.internal.InternalService;

public interface CompoundTag extends Tag, ReadableCompoundTag, WritableCompoundTag {
    static CompoundTag create() {
        return InternalService.getInstance().createCompoundTag();
    }
}