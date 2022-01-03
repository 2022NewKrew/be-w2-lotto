package lotto.step1.util;

public class AutoIncrementIdGenerator {
    private static Long nextId = 0L;

    public static Long get() {
        return ++nextId;
    }
}
