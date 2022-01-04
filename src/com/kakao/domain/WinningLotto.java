package com.kakao.domain;

import java.util.*;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNum;

    public WinningLotto(List<Integer> winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Rank checkRank(Lotto lotto) {
        int matchCnt = 0;
        boolean matchBonus = checkBonusNum(lotto);
        for (int num : lotto.getLotto()) {
            matchCnt += checkNum(num);
        }
        return Rank.valueOf(matchCnt, matchBonus);
    }

    private int checkNum(int num) {
        if (winningLotto.contains(num)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNum(Lotto lotto) {
        return lotto.getLotto().contains(bonusNum);
    }
}
