package org.sandboxpowered.api.item;

import java.util.Optional;

public interface ItemProvider {
    Optional<Item> asItem();
}
