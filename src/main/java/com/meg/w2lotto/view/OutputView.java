package com.meg.w2lotto.view;

import com.meg.w2lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static void printResult(List<Integer> prizes, List<Integer> correctCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (int i = 3; i <= Lotto.NUMCOUNT; i++) {
            System.out.println(String.format("%d개 일치 (%d원)- %d개", i, prizes.get(i), correctCounts.get(i)));
        }
    }

    public static void printRateOfReturn(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
