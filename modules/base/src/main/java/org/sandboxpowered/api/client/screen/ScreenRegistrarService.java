package org.sandboxpowered.api.client.screen;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.registry.Registrar;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;

public interface ScreenRegistrarService extends Registrar.Service {
    void register(ScreenHandler handler);

    @FunctionalInterface
    interface ScreenHandler {
        @Nullable
        Screen createScreen(Identity identity, @Nullable ReadableCompoundTag tag);
    }
}
