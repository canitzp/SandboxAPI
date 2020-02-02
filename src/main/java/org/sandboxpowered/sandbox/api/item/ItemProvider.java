package org.sandboxpowered.sandbox.api.item;

import java.util.Optional;

public interface ItemProvider {
    Optional<Item> asItem();
}
