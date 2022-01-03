package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.domain.Reward;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoGenerator lottoGenerator = new RandomLottoGenerator();

    public List<Lotto> buyLottosFor(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int amount = money.buy(Lotto.PRICE);
        for (int i = 0; i < amount; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }

    public Result check(List<Lotto> lottos, Lotto winningLotto) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            int match = lotto.compare(winningLotto);
            result.add(Reward.of(match));
        }
        return result;
    }
}
