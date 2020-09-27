package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.annotation.Alpha;

@Alpha
public interface LivingEntity extends Entity {
    float getHealth();

    void setHealth(float health);

    default boolean isHoldingItem(Hand hand) {
        return !getHeld(hand).isEmpty();
    }

    void setHeld(Hand hand, ItemStack stack);

    ItemStack getHeld(Hand hand);

    default void swing(Hand hand) {
        swing(hand, false);
    }

    void swing(Hand hand, boolean updateSelf);

    default boolean hasEquipped(EquipmentSlot slot) {
        return !getEquipped(slot).isEmpty();
    }

    ItemStack getEquipped(EquipmentSlot slot);

    void equip(EquipmentSlot slot, ItemStack stack);

    enum EquipmentSlot {
        MAINHAND(Type.HAND),
        OFFHAND(Type.HAND),
        FEET(Type.ARMOR),
        LEGS(Type.ARMOR),
        CHEST(Type.ARMOR),
        HEAD(Type.ARMOR);

        private final EquipmentSlot.Type type;

        EquipmentSlot(Type type) {
            this.type = type;
        }

        public Type getType() {
            return type;
        }

        enum Type {
            HAND,
            ARMOR
        }
    }
}
