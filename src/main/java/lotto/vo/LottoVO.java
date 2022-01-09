package lotto.vo;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVO {

    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;
    public final static int NUMBERS_SIZE = 6;
    public final static int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public LottoVO(Lotto lotto) {
        numbers = Collections.unmodifiableList(lotto.getNumbers().orElseThrow());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
