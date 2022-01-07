package com.meg.w2lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers = new ArrayList<>(LottoConstant.LOTTO_COST);

    public Lotto(List<Integer> numbers) {

        Collections.sort(numbers);
        initLottoNumberList(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public Boolean contains(LottoNumber n) {
        return numbers.contains(n);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private List<LottoNumber> initLottoNumberList(List<Integer> intnumbers) {
        for (int i : intnumbers) {
            this.numbers.add(LottoNumber.valueOf(i));
        }
        return numbers;
    }
}
