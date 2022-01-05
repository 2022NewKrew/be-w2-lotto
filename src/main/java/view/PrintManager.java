package view;

import domain.entity.Lotto;

import java.util.List;

public class PrintManager {
    public static void printNumOfPurchasedLotto(int purchasedAmount){
        System.out.printf("%d개를 구매했습니다.\n", purchasedAmount);
    }
    public static void printPurchasedLottoNums(int numOfManualLotto, List<Lotto> lottoList) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", numOfManualLotto, lottoList.size()-numOfManualLotto);
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
