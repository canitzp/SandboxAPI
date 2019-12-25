package org.sandboxpowered.sandbox.api.enchantment;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.entity.LivingEntity;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;
import org.sandboxpowered.sandbox.api.util.annotation.Beta;

@Beta
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

    enum Target {
    }

    enum Weight {
        COMMON(10),
        UNCOMMON(5),
        RARE(2),
        VERY_RARE(1);

        private final int weight;

        Weight(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}