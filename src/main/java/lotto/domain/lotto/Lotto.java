package lotto.domain.lotto;

import java.util.List;

public interface Lotto {
    int LOTTO_NUMBER_COUNT_MAX = 6;

    List<Integer> getNumbers();
}
