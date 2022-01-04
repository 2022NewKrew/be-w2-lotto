package view;

import domain.entity.Lotto;
import domain.entity.LottoPolicy;

import java.util.List;

public class PrintManager {
    public static void printNumOfPurchasedLotto(int purchasedAmount){
        System.out.printf("%d개를 구매했습니다.\n", purchasedAmount);
    }
    public static void printPuchasedLottoNums(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
    public static void printRewards(List<String> rewardsList) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (String reward : rewardsList) {
            System.out.println(reward);
        }
    }
    public static void printReturnRate(int returnRate) {
        System.out.printf("총 수익률은 %d%%입니다.", returnRate);
    }
}
