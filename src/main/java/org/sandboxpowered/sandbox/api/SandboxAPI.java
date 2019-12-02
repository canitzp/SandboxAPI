package org.sandboxpowered.sandbox.api;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.event.Event;
import org.sandboxpowered.sandbox.api.event.Priority;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Log;
import org.sandboxpowered.sandbox.api.util.Side;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

    default <T extends Content<T>> void register(Identity identity, T content) {
        Registries.getRegistry(content.getContentType()).register(identity, content);
    }

    Log getLog();

    default <T extends Event> void on(Class<T> event, Predicate<T> filter, Consumer<T> consumer) {
        on(event, filter, Priority.NORMAL, false, consumer);
    }

    default <T extends Event> void on(Class<T> event, Consumer<T> consumer) {
        on(event, Priority.NORMAL, false, consumer);
    }

    default <T extends Event> void on(Class<T> event, Predicate<T> filter, Priority priority, Consumer<T> consumer) {
        on(event, filter, priority, false, consumer);
    }

    default <T extends Event> void on(Class<T> event, Priority priority, Consumer<T> consumer) {
        on(event, priority, false, consumer);
    }

    default <T extends Event> void on(Class<T> event, Predicate<T> filter, boolean receiveCancelled, Consumer<T> consumer) {
        on(event, filter, Priority.NORMAL, receiveCancelled, consumer);
    }

    default <T extends Event> void on(Class<T> event, boolean receiveCancelled, Consumer<T> consumer) {
        on(event, Priority.NORMAL, receiveCancelled, consumer);
    }

    default <T extends Event> void on(Class<T> event, Priority priority, boolean receiveCancelled, Consumer<T> consumer) {
        on(event, f -> true, priority, receiveCancelled, consumer);
    }

    <T extends Event> void on(Class<T> event, Predicate<T> filter, Priority priority, boolean receiveCancelled, Consumer<T> consumer);
}