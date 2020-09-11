package org.sandboxpowered.api.entity.player;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.text.Text;

import java.util.Optional;

@Alpha
public interface PlayerEntity extends LivingEntity {
    void sendChatMessage(Text text);

    void sendOverlayMessage(Text text);

    default void openScreen(Identity id) {
        openScreen(id, null);
    }

    void openScreen(Identity id, @Nullable CompoundTag data);

    Optional<Position> getSleepingPosition();

    boolean isSleeping();

    boolean isSleepingIgnored();

    void setSleepingIgnored(boolean ignored);
}
