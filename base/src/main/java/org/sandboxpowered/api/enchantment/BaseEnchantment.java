package org.sandboxpowered.api.enchantment;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.annotation.Alpha;

@Alpha
public abstract class BaseEnchantment implements Enchantment {
    private final int minLevel, maxLevel;
    private final boolean curse, treasure;
    private final Weight weight;

    public BaseEnchantment(int minLevel, int maxLevel, boolean curse, boolean treasure, Weight weight) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.curse = curse;
        this.treasure = treasure;
        this.weight = weight;
    }

    @Override
    public int getMinimumLevel() {
        return minLevel;
    }

    @Override
    public int getMaximumLevel() {
        return maxLevel;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isCurse() {
        return curse;
    }

    @Override
    public boolean isTreasure() {
        return treasure;
    }

    @Override
    public Weight getWeight() {
        return weight;
    }
}
