package lotto.domain.lotto;

import java.util.List;

public interface Lotto {
    int LOTTO_PRICE = 1000;
    int LOTTO_NUMBER_COUNT_MAX = 6;
    int LOTTO_NUMBER_MIN = 1;
    int LOTTO_NUMBER_MAX = 45;

    List<Integer> getNumbers();
}
