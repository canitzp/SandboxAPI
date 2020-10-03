package org.sandboxpowered.api.world;

public enum BlockFlag {
    NOTIFY_NEIGHBORS,
    SEND_TO_CLIENT,
    NO_RERENDER,
    RERENDER_MAIN_THREAD,
    NO_OBSERVER;

    public static final BlockFlag[] DEFAULT = new BlockFlag[]{
            NOTIFY_NEIGHBORS,
            SEND_TO_CLIENT
    };
}
