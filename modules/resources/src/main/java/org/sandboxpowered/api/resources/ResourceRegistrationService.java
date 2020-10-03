package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.registry.Registrar;

public interface ResourceRegistrationService extends Registrar.Service {
    Resource requestResource(ResourceRequest request);

    Resource getResource(String resourceName);
}