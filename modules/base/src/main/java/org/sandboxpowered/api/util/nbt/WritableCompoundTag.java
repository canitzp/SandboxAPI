package org.sandboxpowered.api.util.nbt;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.math.Position;

import java.util.List;
import java.util.UUID;

public interface WritableCompoundTag extends Tag {
    void setInt(String key, int i);

    void setIntArray(String key, int[] i);

    void setString(String key, String s);

    void setDouble(String key, double d);

    void setByte(String key, byte b);

    void setByteArray(String key, byte[] b);

    void setLong(String key, long l);

    void setBoolean(String key, boolean bool);

    void setUUID(String key, UUID uuid);

    void setTag(String key, Tag tag);

    <T extends Tag> void setList(String key, List<T> list);

    void setPosition(String key, Position position);

    void setIdentity(String key, Identity identity);
}