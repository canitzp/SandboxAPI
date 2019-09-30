package org.sandboxpowered.sandbox.api.client;

import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface Session {
    String getUUID();

    String getUsername();
}
