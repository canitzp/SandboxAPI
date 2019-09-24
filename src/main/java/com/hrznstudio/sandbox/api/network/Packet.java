package com.hrznstudio.sandbox.api.network;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.SandboxAPI;

@Beta
public interface Packet {

    void read(ReadableBuffer buffer);

    void write(WritableBuffer buffer);

    void execute(SandboxAPI api);
}
