package org.sandboxpowered.internal;

import com.google.common.collect.Iterators;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.util.annotation.Internal;

import java.util.*;

@Internal
public class SandboxServiceLoader {
    private static final Map<Class<?>, Object> SERVICE_MAP = new HashMap<>();

    @NotNull
    public static <T> T loadService(Class<T> tClass) {
        if (!SERVICE_MAP.containsKey(tClass)) {
            ServiceLoader<T> functionsServiceLoader = ServiceLoader.load(tClass);
            Iterator<T> tIterator = functionsServiceLoader.iterator();
            if (!tIterator.hasNext())
                throw new IllegalStateException(String.format("No services defined for '%s'", tClass));
            T service = tIterator.next();
            if (tIterator.hasNext()) {
                T[] services = Iterators.toArray(functionsServiceLoader.iterator(), tClass);
                services = ArrayUtils.insert(0, services, service);
                throw new IllegalStateException(String.format("There must be exactly 1 service defined for class '%s', all services: '%s'", tClass, Arrays.toString(services)));
            }
            SERVICE_MAP.put(tClass, service);
            return service;
        }
        return tClass.cast(SERVICE_MAP.get(tClass));
    }
}