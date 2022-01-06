package view.util;

public class Validator {

    public static void isPositive(int value) {
        if (value <= 0) {
            throw new NumberFormatException();
        }
    }

    public static void isPositiveLong(long value) {
        if (value <= 0) {
            throw new NumberFormatException();
        }
    }
}
