package org.sandboxpowered.api.client;

import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.internal.InternalService;

@PreAlpha
public interface Client {
    static Client getInstance() {
        return InternalService.getInstance().clientInstance();
    }
}
