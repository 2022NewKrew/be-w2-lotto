package view;

import domain.LotteryGame;
import domain.Rank;

import java.util.*;

public class OutputView {
    private static final String OUTPUT_QUANTITY_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계";
    private static final String OUTPUT_HORIZONTAL_RULE_MESSAGE = "---------";
    private static final String MATCHING_MESSAGE = "%d개 일치 (%d원)- %d개%n";
    private static final String MATCHING_MESSAGE_WITH_BONUS = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";
    private static final String OUTPUT_PROFIT_MESSAGE = "총 수익률은 %d%%입니다.%n";

//    private static final String FIRST_MATCHING_MESSAGE = "6개 일치";
//    private static final String SECOND_MATCHING_MESSAGE = "5개 일치, 보너스 볼 일치";
//    private static final String THIRD_MATCHING_MESSAGE = "5개 일치";
//    private static final String FOURTH_MATCHING_MESSAGE = "4개 일치";
//    private static final String FIFTH_MATCHING_MESSAGE = "3개 일치";
//
//    private static final List<String> MATCHING_LIST = new ArrayList<>(Arrays.asList(
//            FIRST_MATCHING_MESSAGE,
//            SECOND_MATCHING_MESSAGE,
//            THIRD_MATCHING_MESSAGE,
//            FOURTH_MATCHING_MESSAGE,
//            FIFTH_MATCHING_MESSAGE
//    ));

    public static void outputLotteryNumbers(LotteryGame lottery) {
        int quantity = LotteryGame.getQuantity();
        System.out.printf(OUTPUT_QUANTITY_MESSAGE, quantity);
        for (int i = 0; i < quantity; i++) {
            System.out.println(lottery.getLotteries().get(i).getNumbers());
        }
        System.out.println();
    }

    public static void outputResults(Map<Rank, Integer> results, long profit) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(OUTPUT_HORIZONTAL_RULE_MESSAGE);

//        List<Rank> ranks = new ArrayList<>(results.keySet());
//        Collections.sort(ranks);
//
//        for (int i=ranks.size()-2; i>=0; --i) {
//            Rank rank = ranks.get(i);
//            int reward = rank.getWinningMoney();
//            int count = results.get(rank);
//
//            System.out.println(MATCHING_LIST.get(rank.ordinal()) + " (" + reward + "원)- " + count + "개");
//        }

        System.out.printf(MATCHING_MESSAGE, Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), results.get(Rank.FIFTH));
        System.out.printf(MATCHING_MESSAGE, Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), results.get(Rank.FOURTH));
        System.out.printf(MATCHING_MESSAGE, Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), results.get(Rank.THIRD));
        System.out.printf(MATCHING_MESSAGE_WITH_BONUS, Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), results.get(Rank.SECOND));
        System.out.printf(MATCHING_MESSAGE, Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), results.get(Rank.FIRST));

        System.out.printf(OUTPUT_PROFIT_MESSAGE, profit);
    }

}
