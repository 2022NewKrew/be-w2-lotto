package validation;

import java.util.Set;
import java.util.function.Supplier;

public class Validation {

    public static void notLessThanInt(int object, int another, Supplier<RuntimeException> supplier) {
        condition(Integer.compare(object, another) >= 0, supplier);
    }

    public static void notMoreThanInt(int object, int another, Supplier<RuntimeException> supplier) {
        condition(Integer.compare(object, another) <= 0, supplier);
    }

    public static void notLessThanLong(long object, long another, Supplier<RuntimeException> supplier) {
        condition(Long.compare(object, another) >= 0, supplier);
    }

    public static void notMoreThanLong(long object, long another, Supplier<RuntimeException> supplier) {
        condition(Long.compare(object, another) <= 0, supplier);
    }

    public static <T> void sizeShouldBe(Set<T> object, int length, Supplier<RuntimeException> supplier) {
        condition(object.size() == length, supplier);
    }

    public static <T> void notContains(Set<T> object, T another, Supplier<RuntimeException> supplier) {
        condition(!object.contains(another), supplier);
    }

    private static void condition(boolean predicate, Supplier<RuntimeException> supplier) {
        if (!predicate) {
            throw supplier.get();
        }
    }
}
