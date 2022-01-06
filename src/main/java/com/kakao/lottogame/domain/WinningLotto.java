package com.kakao.lottogame.domain;

import com.kakao.lottogame.domain.Rank.Criteria;

public class WinningLotto {

    private static final int BONUS_MATCH = 5;

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 이미 당첨 번호에 속해 있습니다.");
        }
    }

    public Criteria compare(Lotto lotto) {
        int match = lotto.compare(this.lotto);
        if (match == BONUS_MATCH) {
            return Criteria.of(match, lotto.contains(bonusNumber));
        }
        return Criteria.of(match, false);
    }
}
