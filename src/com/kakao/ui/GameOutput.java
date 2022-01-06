package com.kakao.ui;

import com.kakao.domain.Lotto;
import com.kakao.domain.Rank;
import com.kakao.domain.Result;
import com.kakao.domain.WinningLotto;

import java.util.*;

public class GameOutput {

    public void printLottos(List<Lotto> lottos) {
        int customLottoCount = Result.getCutomLottoCount(lottos);
        int autoLottoCount = lottos.size() - customLottoCount;
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", customLottoCount, autoLottoCount);
        lottos.forEach(System.out::println);
    }

    public void printTotalResult(int money, List<Lotto> lottos, WinningLotto winningLotto) {
        Result result = new Result(money, lottos, winningLotto);
        System.out.println("\n당첨 통계\n----------");
        printResult(result.getResult());
        System.out.printf("총 수익률은 %d%% 입니다.\n", result.getProfitRatio());
    }

    private void printResult(Map<Rank, Integer> result) {
        List<Rank> ranks = new ArrayList<>(result.keySet());
        ranks.sort(Comparator.comparingInt(Rank::getCountOfMatch));
        ranks.forEach(rank -> {
            int count = result.get(rank);
            System.out.printf("%s (%d원) - %d개\n", rank.getExplanation(), rank.getWinningMoney(), count);
        });
    }
}
