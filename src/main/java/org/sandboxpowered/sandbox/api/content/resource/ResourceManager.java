package org.sandboxpowered.sandbox.api.content.resource;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Identity;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	private static final Map<String, ResourceType> TYPES = new HashMap<>();

	public static ResourceType requestResource(String source, ResourceRequest request) {
		ResourceType type = TYPES.computeIfAbsent(request.getName(), ResourceType::new);
		type.append(source, request);
		return type;
	}

	public static ResourceType getExistingResource(String source, String resourceName) {
		ResourceType ret = TYPES.get(resourceName);
		if (ret == null) {
			throw new RuntimeException("Addon " + source + " tried to get resource type " + resourceName + " that hasn't been requested!");
		}
		return ret;
	}

	//TODO: put somewhere else? this gets called after all addons get initialized so we can do preferences properly
	public static void register() {
		TYPES.forEach((name, type) -> {
			type.getItemNames().forEach(id -> Registry.getRegistryFromType(Item.class).register(Identity.of("sandbox", id), type.getItem(id).orElseThrow(() ->
					new IllegalStateException("Item named " + id + " was in " + type.getBaseName() + " resource type list but doesn't exist!"))));
			type.getBlockNames().forEach(id -> Registry.getRegistryFromType(Block.class).register(Identity.of("sandbox", id), type.getBlock(id).orElseThrow(() ->
					new IllegalStateException("Block named " + id + " was in " + type.getBaseName() + " resource type list but doesn't exist!"))));
		});
	}

	//TODO: put somewhere else? this is called to wipe existing resource types when you leave
	public static void deregister() {
		TYPES.clear();
	}
}
