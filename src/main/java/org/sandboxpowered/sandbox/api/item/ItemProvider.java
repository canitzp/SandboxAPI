package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.util.Mono;

public interface ItemProvider {
    Mono<Item> asItem();
}
