package lotto.step1.util;

public class AutoIncrementIdGenerator {
    private static long nextId = 0L;

    public static long get() {
        return ++nextId;
    }
}
