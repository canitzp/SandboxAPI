package org.sandboxpowered.internal;

import org.sandboxpowered.api.util.annotation.Internal;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Internal class
 */
@Internal
public class ClassUtil {
    private static final Map<Class<?>, Map<Class<? extends Annotation>, Boolean>> annotationCache = new LinkedHashMap<>();
    private static final Map<Class<?>, List<Class<?>>> superCache = new HashMap<>();

    public static boolean isAnnotationPresent(Class<?> aClass, Class<? extends Annotation> annotation) {
        return annotationCache.computeIfAbsent(aClass, a -> new LinkedHashMap<>()).computeIfAbsent(annotation, annotationClass -> {
            List<Class<?>> classes = lookupAllSuper(aClass);
            for (Class<?> c : classes)
                if (c.isAnnotationPresent(annotationClass))
                    return true;
            return false;
        });
    }


    public static List<Class<?>> lookupAllSuper(Class<?> eventClass) {
        synchronized (superCache) {
            List<Class<?>> eventTypes = superCache.get(eventClass);
            if (eventTypes == null) {
                eventTypes = new ArrayList<>();
                Class<?> clazz = eventClass;
                while (clazz != null) {
                    eventTypes.add(clazz);
                    clazz = clazz.getSuperclass();
                    if (clazz == Object.class)
                        clazz = null;
                }
                superCache.put(eventClass, eventTypes);
            }
            return eventTypes;
        }
    }
}