package org.sandboxpowered.sandbox.api.network;

import org.sandboxpowered.sandbox.api.SandboxAPI;
import org.sandboxpowered.sandbox.api.util.annotation.PreAlpha;

@PreAlpha
public interface Packet {

    void read(ReadableBuffer buffer);

    void write(WritableBuffer buffer);

    void execute(SandboxAPI api);
}
