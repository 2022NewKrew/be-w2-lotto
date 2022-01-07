package com.meg.w2lotto.view;

import com.meg.w2lotto.domain.Lotto;
import com.meg.w2lotto.domain.Prize;

import java.util.Map;

public class OutputView {

    public static final void printPurchaseMessage(int manualCount, int autoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
    }

    public static final void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static final void printResult(Map<Prize, Integer> correctCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (Prize prize : Prize.values()) {
            System.out.print(prize.getMatchCount()+ "개 일치");
            if (prize.isBonus()) System.out.print(", 보너스 볼 일치");
            System.out.println(String.format(" (%d원)- %d개", prize.getWinningMoney(), correctCounts.get(prize)));
        }
    }

    public static final void printRateOfReturn(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
