package org.sandboxpowered.sandbox.api.network;

import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.PreAlpha;
import org.sandboxpowered.sandbox.api.util.math.Position;

@PreAlpha
public interface ReadableBuffer {

    Identity readIdentity();

    Position readPosition();
}
