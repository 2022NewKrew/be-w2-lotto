package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printCountLotto(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<Integer, Integer> result) {
        System.out.println("당첨 통계\n-------");
        for(Integer key : result.keySet()) {
            LottoPrize lottoPrize = LottoPrize.of(key);
            System.out.println(lottoPrize.getMessage() + " (" + lottoPrize.getReward()+ "원)- " + result.get(key) + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%s 입니다.", yield, "%"); // ?
    }
}
