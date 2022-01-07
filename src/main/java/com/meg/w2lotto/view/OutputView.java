package com.meg.w2lotto.view;

import com.meg.w2lotto.domain.lotto.Lotto;
import com.meg.w2lotto.domain.result.Prize;

import java.util.Map;

public class OutputView {

    public static final void printPurchaseMessage(int manualCount, int autoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
    }

    public static final void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printResult(Map<Prize, Integer> correctCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Prize, Integer> entry : correctCounts.entrySet()) {
            System.out.println(getCorrectCountOfPrize(entry.getKey(), entry.getValue()));
        }
    }

    private static String getCorrectCountOfPrize(Prize prize, int count) {
        if (prize == Prize.FAIL) {
            return "";
        }
        return String.format(
                "%d개 일치, %s(%d원)- %d개",
                prize.getMatchCount(),
                prize.isBonus() ? "보너스 볼 일치" : "",
                prize.getWinningMoney(),
                count);
    }

    public static void printRateOfReturn(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
