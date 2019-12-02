package org.sandboxpowered.sandbox.api.enchant;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.item.ItemStack;

public interface Enchantment extends Content<Enchantment> {
    int getMinimumLevel();

    int getMaximumLevel();

    boolean isAcceptableItem(ItemStack stack);

    boolean isCurse();

    boolean isTreasure();

    @Override
    default Class<Enchantment> getContentType() {
        return Enchantment.class;
    }
}