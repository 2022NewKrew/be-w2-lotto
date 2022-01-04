package com.kakao.lottogame.view;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Rank;
import com.kakao.lottogame.domain.Result;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void printResult(Result result, Money money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Iterator<Entry<Rank, Integer>> entries = result.getBoard().entrySet().iterator();
        entries.next();
        while (entries.hasNext()) {
            Entry<Rank, Integer> entry = entries.next();
            Rank rank = entry.getKey();
            System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getMatch(),
                rank.getReward().getValue(), entry.getValue());
        }
        System.out.printf("총 수익률은 %d%%입니다.%n", result.calculateProfit(money));
    }
}
