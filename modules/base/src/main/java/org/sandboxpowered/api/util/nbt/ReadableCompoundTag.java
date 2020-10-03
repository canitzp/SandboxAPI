package org.sandboxpowered.api.util.nbt;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.math.Position;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ReadableCompoundTag extends Tag {
    int size();

    Collection<String> getKeys();

    boolean contains(String key);

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

    Tag getTag(String key);

    <T> List<T> getList(String key, Class<T> tagType);

    CompoundTag getCompound(String key);

    Identity getIdentity(String key);

    Position getPosition(String key);
}