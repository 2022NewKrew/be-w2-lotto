package com.meg.w2lotto.service;

import com.meg.w2lotto.constants.LottoConstant;
import com.meg.w2lotto.domain.lotto.Lotto;
import com.meg.w2lotto.domain.lotto.LottoPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseService {

    private static final PurchaseService INSTANCE = new PurchaseService();
    private static final List<Integer> numbersOfLottoRange = IntStream.range(LottoConstant.LOTTO_NUMBER_MIN, LottoConstant.LOTTO_NUMBER_MAX + 1)
            .boxed()
            .collect(Collectors.toList());

    private PurchaseService() {}

    public static PurchaseService getInstance() {
        return INSTANCE;
    }

    public LottoPack createLottoPack(int count) {
        return new LottoPack(count);
    }

    public void purchaseManualLotto(LottoPack lottoPack, List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottoPack.addLotto(lotto);
    }

    public Lotto purchaseAutoLotto(LottoPack lottoPack) {
        Collections.shuffle(numbersOfLottoRange);
        List<Integer> numbers = new ArrayList<>(numbersOfLottoRange.subList(0, LottoConstant.LOTTO_SIZE));
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        lottoPack.addLotto(lotto);
        return lotto;
    }
}
