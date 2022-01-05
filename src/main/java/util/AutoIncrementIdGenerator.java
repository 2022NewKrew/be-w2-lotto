package util;

public class AutoIncrementIdGenerator {
    private static Long id = 0L;

    public static Long getId() {
        return id++;
    }
}
