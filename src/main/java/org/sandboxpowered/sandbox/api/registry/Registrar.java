package org.sandboxpowered.sandbox.api.registry;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.content.resource.ResourceManager;
import org.sandboxpowered.sandbox.api.content.resource.ResourceRequest;
import org.sandboxpowered.sandbox.api.content.resource.ResourceType;
import org.sandboxpowered.sandbox.api.util.Identity;

//TODO: per-addon instances
public interface Registrar {
    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content);

    default ResourceType requestResource(ResourceRequest request) {
        return ResourceManager.requestResource("sandbox", request); //TODO: fix when we have per-addon instances
    }

    //TODO: better impl once we have per-addon instances
    default ResourceType getResource(String resourceName) {
        return ResourceManager.getExistingResource("sandbox", resourceName); //TODO: fix when we have per-addon instances
    }
}