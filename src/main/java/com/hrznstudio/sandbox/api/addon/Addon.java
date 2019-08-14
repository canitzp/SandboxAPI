package com.hrznstudio.sandbox.api.addon;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.SandboxAPI;

public interface Addon {
    void init(SandboxAPI api);

    default void register(Registries registries) {

    }
}
