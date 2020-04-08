package org.sandboxpowered.sandbox.api.content.resource;

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
}
