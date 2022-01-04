package com.kakao.ui;

import com.kakao.domain.Lotto;
import com.kakao.domain.Rank;
import com.kakao.domain.WinningLotto;

import java.util.*;

public class GameOutput {

    private final Map<Rank, Integer> results = new HashMap<>();

    public GameOutput() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void printLottos(List<Lotto> lottos) {
        int lottoCnt = lottos.size();
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCnt);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(int money, List<Lotto> lottos, WinningLotto winningLotto) {
        System.out.println("\n당첨 통계\n----------");
        checkResults(lottos, winningLotto);

        List<Rank> ranks = new ArrayList<>(results.keySet());
        ranks.sort(Comparator.comparingInt(Rank::getCntOfMatch));
        ranks.forEach(rank -> {
            int cnt = results.get(rank);
            System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getCntOfMatch(), rank.getWinningMoney(), cnt);
        });

        printProfitRatio(money);
    }

    private void checkResults(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            checkResult(lotto, winningLotto);
        }
    }

    private void checkResult(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.checkRank(lotto);
        if (rank != null) {
            results.put(rank, results.get(rank) + 1);
        }
    }

    private void printProfitRatio(int money) {
        int profitRatio = calcProfitRatio(money);
        System.out.printf("총 수익률은 %d%% 입니다.\n", profitRatio);
    }

    private int calcProfitRatio(int money) {
        try {
            int profit = 0;
            for (Rank rank : results.keySet()) {
                profit += rank.getWinningMoney() * results.get(rank);
            }
            return (profit - money) / money * 100;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
