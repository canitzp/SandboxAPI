package org.sandboxpowered.sandbox.api.enchantment;

public enum Weight {
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
