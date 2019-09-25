package org.sandboxpowered.sandbox.api.game;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;

@Beta
public interface GameMode {
    Identity getIdentity();

    String getDisplayName();

    Mono<String> getRichImage();
}
