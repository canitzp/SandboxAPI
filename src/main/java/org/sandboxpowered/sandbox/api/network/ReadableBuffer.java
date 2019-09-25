package org.sandboxpowered.sandbox.api.network;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.math.Position;

@Beta
public interface ReadableBuffer {

    Identity readIdentity();

    Position readPosition();
}
