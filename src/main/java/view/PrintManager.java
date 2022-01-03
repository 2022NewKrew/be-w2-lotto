package view;

import domain.entity.Lotto;

import java.util.List;
import java.util.Map;

public class PrintManager {
    public static void printNumOfPurchasedLotto(int purchasedAmount){
        System.out.printf("%d개를 구매했습니다.\n", purchasedAmount);
    }
    public static void printPuchasedLottoNums(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
    public static void printRewards(Map<Integer, Integer> lottoRewards, Map<Integer, Integer> rewardsForMe) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int matchedNum : lottoRewards.keySet()) {
            int money = lottoRewards.get(matchedNum);
            int result = rewardsForMe.get(matchedNum);
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchedNum, money, result);
        }
    }
    public static void printReturnRate(int returnRate) {
        System.out.printf("총 수익률은 %d%%입니다.", returnRate);
    }
}
