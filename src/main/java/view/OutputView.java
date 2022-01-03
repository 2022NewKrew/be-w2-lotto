package view;

import domain.LotteryGame;
import domain.Result;

import java.util.*;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계";
    private static final String OUTPUT_HORIZONTAL_RULE_MESSAGE = "---------";
    private static final String FIRST_MATCHING_MESSAGE = "6개 일치";
    private static final String SECOND_MATCHING_MESSAGE = "5개 일치";
    private static final String THIRD_MATCHING_MESSAGE = "4개 일치";
    private static final String FOURTH_MATCHING_MESSAGE = "3개 일치";

    private static final List<String> MATCHING_LIST = new ArrayList<>(Arrays.asList(
            FIRST_MATCHING_MESSAGE,
            SECOND_MATCHING_MESSAGE,
            THIRD_MATCHING_MESSAGE,
            FOURTH_MATCHING_MESSAGE
    ));

    public static void outputLotteryNumbers(LotteryGame lottery) {
        int quantity = LotteryGame.getQuantity();
        System.out.println(quantity + "개를 구매했습니다.");
        for (int i = 0; i < quantity; i++) {
            System.out.println(lottery.getLotteries().get(i).getNumbers());
        }
        System.out.println();
    }

    public static void outputResults(Map<Integer, Result> results, long profit) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(OUTPUT_HORIZONTAL_RULE_MESSAGE);

        List<Integer> ranks = new ArrayList<>(results.keySet());
        Collections.sort(ranks);

        for (int rank = MATCHING_LIST.size(); rank > 0; --rank) {
            int reward = results.get(rank).getReward();
            int count = results.get(rank).getCount();
            System.out.println(MATCHING_LIST.get(rank - 1) + " (" + reward + "원)- " + count + "개");
        }
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

}
