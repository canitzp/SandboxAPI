package org.sandboxpowered.sandbox.api.util;

import org.sandboxpowered.sandbox.api.util.annotation.Internal;

import java.util.Iterator;

@Internal
public class IntegerRangeIterator implements Iterator<Integer> {
    private final int start, end;
    private int current;

    public IntegerRangeIterator(int start, int end) {
        this.start = start;
        this.current = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public Integer next() {
        return current++;
    }
}
