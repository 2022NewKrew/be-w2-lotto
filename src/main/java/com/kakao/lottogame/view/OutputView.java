package com.kakao.lottogame.view;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Rank;
import com.kakao.lottogame.domain.Result;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {

    public void printManualInfo() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public void printLottos(List<Lotto> lottos, int manualLottoNum, int autoLottoNum) {
        System.out.printf("%n수동으로 %d개, 자동으로 %d개를 구매했습니다.%n", manualLottoNum, autoLottoNum);
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void printResult(Result result, Money money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        result.getBoardWithout(Rank.NONE).forEach(entry -> System.out.println(makeFormat(entry)));
        System.out.printf("총 수익률은 %d%%입니다.%n", result.calculateProfitRate(money));
    }

    private String makeFormat(Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue();
        if (rank.getBonus()) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", rank.getMatch(),
                rank.getRewardValue(), count);
        }
        return String.format("%d개 일치 (%d원))- %d개", rank.getMatch(), rank.getRewardValue(), count);
    }
}
