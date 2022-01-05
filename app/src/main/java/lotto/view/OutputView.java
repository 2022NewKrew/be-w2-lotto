package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<LottoPrize, Integer> result) {
        System.out.println("당첨 통계\n-------");
        for(LottoPrize lottoPrize : result.keySet()) {
            System.out.println(lottoPrize.getMessage() + " (" + lottoPrize.getReward()+ "원)- " + result.get(lottoPrize) + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%s 입니다.", yield, "%"); // ?
    }
}
