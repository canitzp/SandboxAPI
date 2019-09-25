package org.sandboxpowered.sandbox.api.event;

import org.sandboxpowered.sandbox.api.util.ClassUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Event {

    private final boolean async = ClassUtil.isAnnotationPresent(getClass(), Async.class);
    private final boolean cancellable = ClassUtil.isAnnotationPresent(getClass(), Cancellable.class);
    private final boolean hasResult = ClassUtil.isAnnotationPresent(getClass(), HasResult.class);
    private boolean cancelled, complete;
    private EventResult result;

    public boolean isAsync() {
        return async;
    }

    public boolean isCancellable() {
        return cancellable;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isComplete() {
        return complete;
    }

    protected void checkState() {
        if (isComplete()) {
            throw new UnsupportedOperationException("Cannot modify event in an async context");
        }
    }

    public void cancel() {
        if (!isCancellable())
            throw new UnsupportedOperationException("Cannot cancel non-cancellable event");
        checkState();
        cancelled = true;
    }

    public void complete() {
        complete = true;
    }

    public boolean hasResult() {
        return hasResult;
    }

    public EventResult getResult() {
        return result;
    }

    public void setResult(EventResult result) {
        if (!hasResult())
            throw new UnsupportedOperationException("Cannot set result on non-result event");
        checkState();
        this.result = result;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Cancellable {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Async {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface HasResult {

    }
}