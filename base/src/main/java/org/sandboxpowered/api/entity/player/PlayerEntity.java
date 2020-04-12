package org.sandboxpowered.api.entity.player;

import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.text.Text;

import javax.annotation.Nullable;
import java.util.Optional;

@Alpha
public interface PlayerEntity extends LivingEntity {

    void sendChatMessage(Text text);

    void sendOverlayMessage(Text text);

    default void openContainer(Identity id) {
        openContainer(id, null);
    }

    void openContainer(Identity id, @Nullable CompoundTag data);

    Optional<Position> getSleepingPosition();

    default boolean isSleeping() {
        return getSleepingPosition().isPresent();
    }

    ItemStack getStackInHand(Hand hand);
}