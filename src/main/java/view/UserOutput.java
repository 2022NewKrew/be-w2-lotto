package view;

import model.lotto.LottoRank;

import java.util.List;
import java.util.Map;

public class UserOutput {

    static public void printLotto(List<List<Integer>> lottos) {
        for (List<Integer> numbers : lottos) {
            System.out.println(numbers.toString());
        }
    }

    static public void printRevenueRate(long revenueRate) {
        System.out.println("총 수익률은 " + Math.floor(revenueRate * 100) + "% 입니다.");
    }

    static public void printHistory(Map<LottoRank, Long> result) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치(" + LottoRank.FORTH_PRIZE.getReward() + ") - " + result.get(LottoRank.FORTH_PRIZE) + "개");
        System.out.println("4개 일치(" + LottoRank.THIRD_PRIZE.getReward() + ") - " + result.get(LottoRank.THIRD_PRIZE) + "개");
        System.out.println("5개 일치(" + LottoRank.SECOND_PRIZE.getReward() + ") - " + result.get(LottoRank.SECOND_PRIZE) + "개");
        System.out.println("6개 일치(" + LottoRank.FIRST_PRIZE.getReward() + ") - " + result.get(LottoRank.FIRST_PRIZE) + "개");
    }

    static public void printBuyMessage(long numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }
}
