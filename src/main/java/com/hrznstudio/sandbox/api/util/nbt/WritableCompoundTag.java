package com.hrznstudio.sandbox.api.util.nbt;

import java.util.UUID;

public interface WritableCompoundTag {
    void setInt(String key, int i);

    void setIntArray(String key, int[] i);

    void setString(String key, String s);

    void setDouble(String key, double d);

    void setByte(String key, byte b);

    void setByteArray(String key, byte[] b);

    void setLong(String key, long l);

    void setBoolean(String key, boolean bool);

    void setUUID(String key, UUID uuid);
}
