package com.hrznstudio.sandbox.api.game;

import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.Mono;

public interface GameMode {
    Identity getIdentity();

    String getDisplayName();

    Mono<String> getRichImage();
}
