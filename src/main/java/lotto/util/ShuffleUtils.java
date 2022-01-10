package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.LottoGame;

public class ShuffleUtils {

    private static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        for (int i = LottoGame.getMinNumber(); i <= LottoGame.getMaxNumber(); i++) {
            NUMBERS.add(i);
        }
    }

    public static List<Integer> getNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, LottoGame.getLottoNumberSize());
    }
}
