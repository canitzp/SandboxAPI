package com.hrznstudio.sandbox.api.entity.player;

import com.hrznstudio.sandbox.api.entity.ILivingEntity;
import com.hrznstudio.sandbox.api.util.text.Text;

public interface Player extends ILivingEntity {

    void sendChatMessage(Text text);

    void sendOverlayMessage(Text text);

}
