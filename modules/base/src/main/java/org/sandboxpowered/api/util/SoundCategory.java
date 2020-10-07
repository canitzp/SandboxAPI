package org.sandboxpowered.api.util;

import org.sandboxpowered.internal.InternalService;

public interface SoundCategory {
    SoundCategory MASTER = get("MASTER");
    SoundCategory MUSIC = get("MUSIC");
    SoundCategory RECORDS = get("RECORD");
    SoundCategory WEATHER = get("WEATHER");
    SoundCategory BLOCKS = get("BLOCK");
    SoundCategory HOSTILE = get("HOSTILE");
    SoundCategory NEUTRAL = get("NEUTRAL");
    SoundCategory PLAYERS = get("PLAYER");
    SoundCategory AMBIENT = get("AMBIENT");
    SoundCategory VOICE = get("VOICE");

    String getName();

    static SoundCategory get(String name) {
        return InternalService.getInstance().getSoundCategory(name);
    }
}
