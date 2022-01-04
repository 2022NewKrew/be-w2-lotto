package com.meg.w2lotto.view;

import com.meg.w2lotto.domain.Lotto;
import com.meg.w2lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final void printPurchaseMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static final void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static final void printResult(Map<Prize, Integer> correctCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (Prize prize : Prize.values()) {
            System.out.print(prize.getMatchCount()+ "개 일치");
            if (prize.getIsBonus()) System.out.print(", 보너스 볼 일치");
            System.out.println(String.format(" (%d원)- %d개", prize.getWinningMoney(), correctCounts.get(prize)));
        }
    }

    public static final void printRateOfReturn(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
