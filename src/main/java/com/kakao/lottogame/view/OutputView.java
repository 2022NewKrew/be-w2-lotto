package com.kakao.lottogame.view;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.domain.Reward;
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
        Iterator<Entry<Reward, Integer>> entries = result.getResult().entrySet().iterator();
        entries.next();
        while (entries.hasNext()) {
            Entry<Reward, Integer> entry = entries.next();
            Reward reward = entry.getKey();
            System.out.printf("%d개 일치 (%d원)- %d개%n", reward.getMatch(),
                reward.getValue().getValue(), entry.getValue());
        }
        System.out.printf("총 수익률은 %d%%입니다.%n", result.getProfit(money));
    }
}
