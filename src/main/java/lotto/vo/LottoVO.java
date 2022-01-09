package lotto.vo;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVO {

    private final List<Integer> numbers;

    public LottoVO(Lotto lotto) {
        numbers = Collections.unmodifiableList(lotto.getNumbers().orElseThrow());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
