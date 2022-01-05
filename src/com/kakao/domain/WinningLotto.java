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
        int countOfMatch = 0;
        boolean matchBonus = checkBonusNumber(lotto);
        for (int number : lotto.getLotto()) {
            countOfMatch += checkNumber(number);
        }
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int checkNumber(int number) {
        if (winningLotto.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }
}
