package com.hrznstudio.sandbox.api.game;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.Mono;

@Beta
public interface GameMode {
    Identity getIdentity();

    String getDisplayName();

    Mono<String> getRichImage();
}
