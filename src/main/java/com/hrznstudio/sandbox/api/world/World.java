package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.util.Side;

public interface World extends WorldReader,WorldWriter {

    Side getSide();
}
