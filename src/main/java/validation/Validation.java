package validation;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class Validation {

    public static void notLessThanLong(long object, long another, Supplier supplier) {
        condition(Long.compare(object, another) >= 0, supplier);
    }

    public static void notMoreThanLong(long object, long another, Supplier supplier) {
        condition(Long.compare(object, another) <= 0, supplier);
    }

    public static <T> void sizeShouldBe(Set<T> object, int length, Supplier supplier) {
        condition(object.size() == length, supplier);
    }

    public static <T> void notContains(Set<T> object, T another, Supplier supplier) {
        condition(!object.contains(another), supplier);
    }

    private static void condition(boolean predicate, Supplier supplier) {
        Optional.ofNullable(predicate ? predicate : null).orElseThrow(supplier);
    }
}
