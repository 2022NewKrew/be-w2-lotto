package com.meg.w2lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    static List<Integer> numbersOfLottoRange = IntStream.range(Lotto.NUMMIN, Lotto.NUMMAX+1)
            .boxed()
            .collect(Collectors.toList());

    public static final Lotto createAutoLotto() {
        Collections.shuffle(numbersOfLottoRange);
        List<Integer> numbers = new ArrayList<>(numbersOfLottoRange.subList(0, Lotto.SIZE));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static final Lotto createManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
