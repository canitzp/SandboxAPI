package org.sandboxpowered.internal;

import com.google.common.collect.Iterators;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@org.sandboxpowered.api.util.annotation.Internal
public class SandboxServiceLoader {
    private static final Map<Class<?>, Object> SERVICE_MAP = new HashMap<>();

    @NotNull
    public static <T> T loadService(Class<T> tClass) {
        if (!SERVICE_MAP.containsKey(tClass)) {
            ServiceLoader<T> functionsServiceLoader = ServiceLoader.load(tClass);
            T[] services = Iterators.toArray(functionsServiceLoader.iterator(), tClass);
            if (services.length == 0)
                throw new IllegalStateException("No services defined, require 1");
            if (services.length > 1)
                throw new IllegalStateException(String.format("Cannot have more than 2 services defined, all services [%s]", Arrays.toString(services)));
            SERVICE_MAP.put(tClass, services[0]);
        }
        return tClass.cast(SERVICE_MAP.get(tClass));
    }
}