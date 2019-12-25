package org.sandboxpowered.sandbox.api.enchantment;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.entity.LivingEntity;
import org.sandboxpowered.sandbox.api.item.ItemStack;

public interface Enchantment extends Content<Enchantment> {
    int getMinimumLevel();

    int getMaximumLevel();

    boolean isAcceptableItem(ItemStack stack);

    boolean isCurse();

    boolean isTreasure();

    Weight getWeight();

    default void onTargetDamage(LivingEntity self, Entity victim, int level) {

    }

    default void onUserDamage(LivingEntity self, Entity attacker, int level) {

    }

    @Override
    default Class<Enchantment> getContentType() {
        return Enchantment.class;
    }
}