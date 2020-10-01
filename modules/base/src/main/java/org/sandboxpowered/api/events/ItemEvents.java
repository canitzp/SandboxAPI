package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.internal.InternalService;

public final class ItemEvents {
    public static final EventHandler<ArrowTypeEvent> GET_ARROW_TYPE = InternalService.getInstance().createEventHandler();
    public static final EventHandler<DamageEvent> DAMAGE = InternalService.getInstance().createEventHandler();
    public static final EventHandler<MiningSpeedEvent> MINING_SPEED = InternalService.getInstance().createEventHandler();

    public interface MiningSpeedEvent {
        float onEvent(PlayerEntity player, ItemStack stack, BlockState state, float speed);
    }

    public interface DamageEvent {
        int onEvent(PlayerEntity player, ItemStack stack, int damage);
    }

    public interface ArrowTypeEvent {
        ItemStack onEvent(PlayerEntity entity, ItemStack bow, ItemStack arrow);
    }
}