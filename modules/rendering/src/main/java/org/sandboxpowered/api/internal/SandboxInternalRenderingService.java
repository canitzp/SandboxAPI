package org.sandboxpowered.api.internal;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.client.rendering.model.LegacyEntityModel;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.internal.SandboxServiceLoader;

public interface SandboxInternalRenderingService {
    @NotNull
    static SandboxInternalRenderingService getInstance() {
        return SandboxServiceLoader.getOrLoadService(SandboxInternalRenderingService.class);
    }

    <T extends Entity> LegacyEntityModel.Bone createBone(LegacyEntityModel tLegacyEntityModel);
}