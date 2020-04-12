package org.sandboxpowered.api.util;

import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.world.World;

public interface ItemUse {
	static ItemUse of(World world, PlayerEntity player, Hand hand, ItemStack stack) {
		throw new UnsupportedOperationException("Not yet implemented!");
	}

	World getWorld();
	PlayerEntity getPlayer();
	Hand getHand();
	ItemStack getStack();
	//TODO: block hit
}
