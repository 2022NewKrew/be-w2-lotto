package domain;

import java.util.List;

public class Validator {
    public static void checkPositiveInteger(int number, String msg) throws Exception {
        if (number < 0)
            throw new IllegalArgumentException(msg);
    }

    public static void checkSizeOfLotto(int size, String msg) throws Exception {
        if (size != 6)
            throw new IllegalArgumentException(msg);
    }

    public static void checkSizeOfLotto(List<Integer> numbers, String msg) throws Exception {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(msg);
    }
}
