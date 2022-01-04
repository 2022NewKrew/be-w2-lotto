package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Rank;
import com.kakao.lottogame.domain.Result;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService() {
        lottoGenerator = new RandomLottoGenerator();
    }

    public LottoService(long seed) {
        lottoGenerator = new RandomLottoGenerator(seed);
    }

    public List<Lotto> buyLottosFor(Money money) {
        int amount = money.buy(Lotto.PRICE);
        return Stream.generate(lottoGenerator::generate)
            .limit(amount)
            .collect(Collectors.toList());
    }

    public Result collate(List<Lotto> lottos, Lotto winningLotto) {
        List<Rank> ranks = lottos.stream()
            .map(lotto -> lotto.compare(winningLotto))
            .map(Rank::of)
            .collect(Collectors.toList());
        return Result.from(ranks);
    }
}
