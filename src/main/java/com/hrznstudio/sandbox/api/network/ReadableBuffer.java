package com.hrznstudio.sandbox.api.network;

import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.math.Position;

public interface ReadableBuffer {

    Identity readIdentity();

    Position readPosition();
}
