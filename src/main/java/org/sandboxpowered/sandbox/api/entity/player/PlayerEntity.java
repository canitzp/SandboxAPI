package org.sandboxpowered.sandbox.api.entity.player;

import org.sandboxpowered.sandbox.api.entity.LivingEntity;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;
import org.sandboxpowered.sandbox.api.util.nbt.CompoundTag;
import org.sandboxpowered.sandbox.api.util.text.Text;

@Alpha
public interface PlayerEntity extends LivingEntity {

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