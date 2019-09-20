package com.hrznstudio.sandbox.api.network;

import com.hrznstudio.sandbox.api.SandboxAPI;
import com.hrznstudio.sandbox.api.util.nbt.ReadableCompoundTag;
import com.hrznstudio.sandbox.api.util.nbt.WritableCompoundTag;

public interface Packet {

    void read(ReadableBuffer buffer);

    void write(WritableBuffer buffer);

    void execute(SandboxAPI api);
}
