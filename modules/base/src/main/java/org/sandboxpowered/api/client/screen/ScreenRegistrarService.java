package org.sandboxpowered.api.client.screen;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.registry.Registrar;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;

public interface ScreenRegistrarService extends Registrar.Service {
    void register(ModHolder holder);

    @FunctionalInterface
    interface ModHolder {
        @Nullable
        Screen createScreen(Identity identity, @Nullable CompoundTag tag);
    }
}
