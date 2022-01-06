package com.chanminkim.w2.precondition;

public interface Precondition {
    static void throwIf(boolean b, RuntimeException exception) {
        if (b) {
            throw exception;
        }
    }

    static void throwIfNot(boolean b, RuntimeException exception) {
        if (!b) {
            throw exception;
        }
    }
}
