package com.kakao.domain;

import java.util.*;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank checkRank(Lotto lotto) {
        int countOfMatch = (int) lotto.getLottoNumbers().stream()
                .filter(this::checkNumber)
                .count();
        boolean matchBonus = checkBonusNumber(lotto);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private boolean checkNumber(int number) {
        return winningLotto.contains(number);
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }
}
