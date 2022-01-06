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

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<LottoPrize, Integer> result) {
        System.out.println("당첨 통계\n-------");
        for (LottoPrize lottoPrize : result.keySet()) {
            System.out.println(getMessageFromLottoPrize(lottoPrize) + " (" + lottoPrize.getReward()+ "원)- " + result.get(lottoPrize) + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%s 입니다.", yield, "%"); // ?
    }

    private static String getMessageFromLottoPrize(LottoPrize lottoPrize) {
        switch (lottoPrize){
            case FIFTH_PLACE:   return "3개 일치";
            case FOURTH_PLACE:  return "4개 일치";
            case THIRD_PLACE:   return "5개 일치";
            case SECOND_PLACE:  return "5개 일치, 보너스 볼 일치";
            case FIRST_PLACE:   return "6개 일치";
            default: return null;
        }
    }
}
