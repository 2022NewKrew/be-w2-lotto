package validation;

import java.util.Set;

public class Validation {
    public static void notLessThanLong(long object, long another, RuntimeException runtimeException) {
        condition(Long.compare(object, another) >= 0, runtimeException);
    }

    public static void notMoreThanLong(long object, long another, RuntimeException runtimeException) {
        condition(Long.compare(object, another) <= 0, runtimeException);
    }

    public static <T> void sizeShouldBe(Set<T> object, int length, RuntimeException runtimeException) {
        condition(object.size() == length, runtimeException);
    }

    public static <T> void notContains(Set<T> object, T another, RuntimeException runtimeException) {
        condition(!object.contains(another), runtimeException);
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
