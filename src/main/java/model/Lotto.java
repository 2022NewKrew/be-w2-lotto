package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import static CONST.Const.*;


public class Lotto {
    private static final Random random = new Random();
    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = random
                .ints(LOTTO_START_NUM, LOTTO_END_NUM + 1)
                .distinct()
                .limit(LOTTO_SELECT_NUM)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public int checkNumber(List<Integer> winningNumber, int bonusNumber) {
        int correctCount = (int) winningNumber
                .stream()
                .filter(lotto::contains)
                .count();
        if (correctCount == LOTTO_FIVE_WIN & lotto.contains(bonusNumber)) {
            return LOTTO_FIVE_BONUS_WIN;
        }
        return correctCount;
    }
}
