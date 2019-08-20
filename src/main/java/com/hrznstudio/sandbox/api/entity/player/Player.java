package com.hrznstudio.sandbox.api.entity.player;

import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.util.text.Text;

public interface Player extends Entity {

    void sendChatMessage(Text text);

    void sendOverlayMessage(Text text);

}
