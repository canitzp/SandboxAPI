package org.sandboxpowered.api.client;

import org.sandboxpowered.internal.InternalService;

public interface Client {
    static Client getInstance() {
        return InternalService.getInstance().clientInstance();
    }
}
