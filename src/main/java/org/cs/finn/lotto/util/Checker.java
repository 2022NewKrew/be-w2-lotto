package org.cs.finn.lotto.util;

public final class Checker {

    private Checker() {}

    public static void checkIntBound (
            final int val,
            final int min,
            final int max
    ) throws IllegalArgumentException, IndexOutOfBoundsException
    {
        if (val < 0 || min < 0 || max < 0) {
            throw new IllegalArgumentException("val or min or max is not 0 or positive integer! - [" + val + ", " + min + ", " + max + "]");
        }
        if (val != Math.max(min, Math.min(val, max))) {
            throw new IndexOutOfBoundsException(val + " is out of [" + min + ", " + max + "]");
        }
    }

    public static void checkInt (
            final int value,
            final boolean zeroToFail
    ) throws IllegalArgumentException
    {
        if (!zeroToFail && value < 0) {
            throw new IllegalArgumentException("value integer is not 0 or positive integer! - " + value);
        }
        if (zeroToFail && value <= 0) {
            throw new IllegalArgumentException("value integer is not positive integer! - " + value);
        }
    }

    public static void checkIntMinMax (
            final int min,
            final int max
    ) throws IllegalStateException
    {
        if (min < 0 || max < 0) {
            throw new IllegalStateException("min or max is not 0 or positive integer! - [" + min + ", " + max + "]");
        }
        if (min > max) {
            throw new IllegalStateException("min value(" + min + ") is greater then max value(" + max + ")");
        }
    }

    public static void checkString (
            final String str
    ) throws IllegalArgumentException
    {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String is null or blank!");
        }
    }
}
