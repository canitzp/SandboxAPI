package com.hrznstudio.sandbox.api.event.entity;

import com.hrznstudio.sandbox.api.entity.player.Player;

public class PlayerEvent extends LivingEvent {
    private final Player player;

    public PlayerEvent(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public Player getEntity() {
        return player;
    }
}