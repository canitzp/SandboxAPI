package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.resources.resource.Resource;
import org.sandboxpowered.api.resources.resource.ResourceManager;
import org.sandboxpowered.api.resources.resource.ResourceRequest;
import org.sandboxpowered.api.util.Identity;

public interface Registrar {
    AddonInfo getSourceAddon();

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content);

    default <T extends Content<T>> Registry.Entry<T> register(String name, T content) {
        return register(Identity.of(getSourceAddon().getId(), name), content);
    }

    default Resource requestResource(ResourceRequest request) {
        return ResourceManager.requestResource(getSourceAddon().getId(), request);
    }

    default Resource getResource(String resourceName) {
        return ResourceManager.getExistingResource(getSourceAddon().getId(), resourceName);
    }
}
