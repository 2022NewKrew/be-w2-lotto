package com.kakao.lottogame.domain;

import com.kakao.lottogame.domain.Rank.Criteria;

public class WinningLotto {

    private static final int BONUS_MATCH = 5;

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Criteria compare(Lotto lotto) {
        int match = lotto.compare(this.lotto);
        if (match == BONUS_MATCH) {
            return Criteria.of(match, lotto.contains(bonusNumber));
        }
        return Criteria.of(match, false);
    }
}
