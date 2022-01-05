package com.yapark97.lottoapplication.domain.lottocreatestrategy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;
import com.yapark97.lottoapplication.domain.lotto.LottoConst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoCreateStrategy implements LottoCreateStrategy{
    private final List<Integer> numberPool;

    public RandomLottoCreateStrategy() {
        numberPool = IntStream.rangeClosed(1, LottoConst.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Lotto create() {
        Collections.shuffle(numberPool);
        List<Integer> picked = new ArrayList<>(numberPool.subList(0, LottoConst.LOTTO_NUMBERS_SIZE));
        Collections.sort(picked);
        return new Lotto(picked);
    }
}
