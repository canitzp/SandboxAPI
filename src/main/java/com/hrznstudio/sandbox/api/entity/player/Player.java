package com.hrznstudio.sandbox.api.entity.player;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.entity.ILivingEntity;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.util.nbt.CompoundTag;
import com.hrznstudio.sandbox.api.util.text.Text;

@Beta
public interface Player extends ILivingEntity {

    void sendChatMessage(Text text);

    void sendOverlayMessage(Text text);

    default void openContainer(Identity id) {
        openContainer(id, Mono.empty());
    }

    default void openContainer(Identity id, CompoundTag data) {
        openContainer(id, Mono.of(data));
    }

    void openContainer(Identity id, Mono<CompoundTag> data);
}