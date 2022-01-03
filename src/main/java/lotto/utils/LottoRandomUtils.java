package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomUtils {

    private static final int SIZE = 6;
    private static final int MIN_NUMBERS = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBERS; i <= MAX_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    private LottoRandomUtils() {
    }

    public static List<Integer> getNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, SIZE);
    }
}
