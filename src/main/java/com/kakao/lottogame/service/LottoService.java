package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import com.kakao.lottogame.domain.Rank;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.domain.WinningLotto;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService() {
        lottoGenerator = new LottoGenerator();
    }

    public Lotto generateManual(List<Integer> lottoNumbers) {
        return lottoGenerator.generateManual(lottoNumbers);
    }

    public WinningLotto generateWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return WinningLotto.of(generateManual(lottoNumbers), LottoNumber.of(bonusNumber));
    }

    public Lotto generateAuto() {
        return lottoGenerator.generateAuto();
    }

    public Result collate(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = lottos.stream()
            .map(winningLotto::compare)
            .map(Rank::of)
            .collect(Collectors.toList());
        return Result.from(ranks);
    }
}
