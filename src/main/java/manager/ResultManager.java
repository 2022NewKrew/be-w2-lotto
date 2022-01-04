package manager;

import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultManager {
    private static final int NUM_PER_LINE = 6;
    private static final int FIRST = 2000000000;
    private static final int SECOND = 1500000;
    private static final int THIRD = 50000;
    private static final int FORTH = 5000;
    private static final int FIFTH = 0;
    private static final int SIXTH = 0;
    private static final int NO_MATCH = 0;
    private static final int START_MATCH_NUM = 3;

    private ResultManager() {
    }

    public static void printResult(int numLines, List<Integer> resultList) {
        int totalWinning = 0;
        List<Integer> priceLst = new ArrayList<>(Arrays.asList(NO_MATCH, SIXTH, FIFTH, FORTH, THIRD, SECOND, FIRST));

        OutputView.printPreResult();
        for (int i = START_MATCH_NUM; i <= NUM_PER_LINE; i++) {
            OutputView.printResult(i, priceLst.get(i), resultList.get(i));
            totalWinning += priceLst.get(i) * resultList.get(i);
        }

        OutputView.printYield(totalWinning / (numLines * 1000) * 100);
    }
}
