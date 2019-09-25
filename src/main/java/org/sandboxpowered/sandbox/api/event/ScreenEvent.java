package org.sandboxpowered.sandbox.api.event;

import org.sandboxpowered.sandbox.api.client.screen.Screen;

public class ScreenEvent extends Event {
    private final Screen screen;

    public ScreenEvent(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    @Cancellable
    public static class Open extends ScreenEvent {
        private Screen screen;

        public Open(Screen screen) {
            super(screen);
            this.screen = screen;
        }

        @Override
        public Screen getScreen() {
            return screen;
        }

        public void setScreen(Screen screen) {
            checkState();
            this.screen = screen;
        }
    }

    @Cancellable
    public static class Close extends ScreenEvent {
        public Close(Screen screen) {
            super(screen);
        }
    }
}