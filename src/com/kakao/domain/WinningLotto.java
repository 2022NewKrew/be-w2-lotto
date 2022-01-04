package com.kakao.domain;

import java.util.*;

public class WinningLotto {

    private final List<Integer> winningLotto;

    public WinningLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Rank checkRank(Lotto lotto) {
        int matchCnt = 0;
        for (int num : lotto.getLotto()) {
            matchCnt += checkNum(num);
        }
        return Rank.valueOf(matchCnt);
    }

    private int checkNum(int num) {
        if (winningLotto.contains(num)) {
            return 1;
        }
        return 0;
    }

}
