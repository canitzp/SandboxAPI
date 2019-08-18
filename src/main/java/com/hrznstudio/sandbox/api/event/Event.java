package com.hrznstudio.sandbox.api.event;

public class Event {

    public boolean isAsync() {
        return false;
    }

    public boolean isCancellable() {
        return false;
    }

    public void complete() {

    }
}
