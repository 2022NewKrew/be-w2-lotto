package validation;

import java.util.List;

public class Validation {
    public static void notLessThanLong(long object, long another, RuntimeException runtimeException) {
        condition(Long.compare(object, another) >= 0, runtimeException);
    }

    public static void notMoreThanLong(long object, long another, RuntimeException runtimeException) {
        condition(Long.compare(object, another) <= 0, runtimeException);
    }

    public static <T> void lengthShouldBe(List<T> object, int length, RuntimeException runtimeException) {
        condition(object.size() == length, runtimeException);
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
