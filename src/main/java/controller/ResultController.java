package controller;

import domain.MatchScore;
import view.OutputView;

import java.util.List;

public class ResultController {
    private ResultController() {
    }

    public static void printResult(int numLotto) {
        OutputView.printPreResult();

        List<MatchScore> msLst = MatchScore.getWinObjLst();

        for (MatchScore ms : msLst) {
            OutputView.printResult(ms.getMatchNums(), ms.isMatchBonus(), ms.getPrice(), ms.getNumLotto());
        }
        OutputView.printYield(MatchScore.getTotalPrice()/(numLotto*1000)*100);
    }
}
