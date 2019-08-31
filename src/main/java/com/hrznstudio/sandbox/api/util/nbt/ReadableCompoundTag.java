package com.hrznstudio.sandbox.api.util.nbt;

import java.util.Collection;
import java.util.UUID;

public interface ReadableCompoundTag {
    int size();

    Collection<String> getKeys();

    int getInt(String key);

    int[] getIntArray(String key);

    String getString(String key);

    double getDouble(String key);

    byte getByte(String key);

    byte[] getByteArray(String key);

    long getLong(String key);

    boolean getBoolean(String key);

    UUID getUUID(String key);

    boolean remove(String key);
}
