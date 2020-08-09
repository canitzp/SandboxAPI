package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.ResettableEventHandler;

public class ItemEvents {
    public static final EventHandler<ArrowTypeEvent> GET_ARROW_TYPE = new ResettableEventHandler<>();
    public static final EventHandler<DamageEvent> DAMAGE = new ResettableEventHandler<>();
    public static final EventHandler<MiningSpeedEvent> MINING_SPEED = new ResettableEventHandler<>();

    public interface MiningSpeedEvent {
        float onEvent(ItemStack stack, BlockState state, float speed);
    }

    public interface DamageEvent {
        int onEvent(PlayerEntity player, ItemStack stack, int damage);
    }

    public interface ArrowTypeEvent {
        ItemStack onEvent(PlayerEntity entity, ItemStack bow, ItemStack arrow);
    }
}