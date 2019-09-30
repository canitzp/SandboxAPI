package org.sandboxpowered.sandbox.api.game;

import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.PreAlpha;

@PreAlpha
public interface GameMode {
    Identity getIdentity();

    String getDisplayName();

    Mono<String> getRichImage();
}
