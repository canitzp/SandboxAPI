package com.hrznstudio.sandbox.api;

import com.hrznstudio.sandbox.api.event.Event;
import com.hrznstudio.sandbox.api.event.GenericEvent;
import com.hrznstudio.sandbox.api.event.Priority;
import com.hrznstudio.sandbox.api.util.Side;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

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

    default <T extends GenericEvent<G>, G> void onGeneric(Class<G> filter, Consumer<T> consumer) {
        onGeneric(filter, Priority.NORMAL, false, consumer);
    }

    default <T extends GenericEvent<G>, G> void onGeneric(Class<G> filter, Priority priority, Consumer<T> consumer) {
        onGeneric(filter, priority, false, consumer);
    }

    default <T extends GenericEvent<G>, G> void onGeneric(Class<G> filter, boolean receiveCancelled, Consumer<T> consumer) {
        onGeneric(filter, Priority.NORMAL, receiveCancelled, consumer);
    }

    <T extends GenericEvent<G>, G> void onGeneric(Class<G> filter, Priority priority, boolean receiveCancelled, Consumer<T> consumer);
}