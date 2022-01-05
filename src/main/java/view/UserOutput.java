package view;

import model.lotto.LottoRank;

import java.util.List;
import java.util.Map;

public class UserOutput {

    public static void printLotto(List<List<Integer>> lottos) {
        for (List<Integer> numbers : lottos) {
            System.out.println(numbers.toString());
        }
    }

    public static void printRevenueRate(int revenueRate) {
        System.out.println("총 수익률은 " + revenueRate + "% 입니다.");
    }

    public static void printHistory(List<LottoRank> lottoRanks, Map<Integer, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (LottoRank value : lottoRanks) {
            printResultByLottoRank(value, result);
        }
    } // 스트링 포맷

    public static void printBuyMessage(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    private static void printResultByLottoRank(LottoRank lottoRank, Map<Integer, Integer> result) {
        System.out.println(getFormattedString(lottoRank, result));
    }

    private static String getFormattedString(LottoRank lottoRank, Map<Integer, Integer> result){
        if (result.containsKey(lottoRank.getReward())){
            return getResultFormat(lottoRank.getMatchNumber(), lottoRank.getReward(), result.get(lottoRank.getReward()));
        }
        return getResultFormat(lottoRank.getMatchNumber(), lottoRank.getReward(), 0);
    }

    private static String getResultFormat(int matchingNumber, int reward, int numberOfMatchTicket){
        return String.format("%d개 일치(%d) - %d개", matchingNumber, reward, numberOfMatchTicket);
    }

}
