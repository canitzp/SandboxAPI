package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.util.Functions;

public interface Stack {
    static Stack of(Item item) {
        return of(item, 1);
    }

    static Stack of(ItemProvider item) {
        return of(item.asItem(), 1);
    }

    static Stack of(ItemProvider item, int amount) {
        return of(item.asItem(), amount);
    }

    static Stack of(Item item, int amount) {
        return Functions.itemStackFunction.apply(item, amount);
    }

    boolean isEmpty();

    Item getItem();

    int getCount();

    default Stack shrink() {
        return shrink(1);
    }

    Stack shrink(int amount);

    default Stack grow() {
        return shrink(1);
    }

    Stack grow(int amount);

    Stack setCount(int amount);
}