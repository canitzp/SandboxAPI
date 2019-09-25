package org.sandboxpowered.sandbox.api.event.entity;

import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;

public class PlayerEvent extends LivingEvent {
    private final PlayerEntity player;

    public PlayerEvent(PlayerEntity player) {
        super(player);
        this.player = player;
    }

    @Override
    public PlayerEntity getEntity() {
        return player;
    }
}