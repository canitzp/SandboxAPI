package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.content.resource.ResourceManager;
import org.sandboxpowered.api.content.resource.ResourceRequest;
import org.sandboxpowered.api.content.resource.Resource;
import org.sandboxpowered.api.util.Identity;

//TODO: per-addon instances
public interface Registrar {
    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content);

    default Resource requestResource(ResourceRequest request) {
        return ResourceManager.requestResource("sandbox", request); //TODO: fix when we have per-addon instances
    }

    default Resource getResource(String resourceName) {
        return ResourceManager.getExistingResource("sandbox", resourceName); //TODO: fix when we have per-addon instances
    }
}
