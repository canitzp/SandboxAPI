package com.hrznstudio.sandbox.api.util.nbt;

import com.hrznstudio.sandbox.api.util.Functions;

public interface CompoundTag extends Tag, ReadableCompoundTag, WritableCompoundTag {
    static CompoundTag create() {
        return Functions.compoundTagCreator.get();
    }
}