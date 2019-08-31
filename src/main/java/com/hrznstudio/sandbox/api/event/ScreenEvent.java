package com.hrznstudio.sandbox.api.event;

import com.hrznstudio.sandbox.api.client.screen.IScreen;

public class ScreenEvent extends Event {
    private final IScreen screen;

    public ScreenEvent(IScreen screen) {
        this.screen = screen;
    }

    public IScreen getScreen() {
        return screen;
    }

    public static class Open extends ScreenEvent {
        private IScreen screen;

        public Open(IScreen screen) {
            super(screen);
            this.screen = screen;
        }

        @Override
        public IScreen getScreen() {
            return screen;
        }

        public void setScreen(IScreen screen) {
            checkState();
            this.screen = screen;
        }
    }

    @Cancellable
    public static class Close extends ScreenEvent {
        public Close(IScreen screen) {
            super(screen);
        }
    }
}