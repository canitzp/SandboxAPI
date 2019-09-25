package org.sandboxpowered.sandbox.api.network;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.SandboxAPI;

@Beta
public interface Packet {

    void read(ReadableBuffer buffer);

    void write(WritableBuffer buffer);

    void execute(SandboxAPI api);
}
