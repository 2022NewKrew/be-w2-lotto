package controller;

import DTO.ResultDTO;
import domain.MatchScore;
import view.OutputView;

import java.util.List;

public class ResultController {
    private static final Long PRICE_PER_LOTTO = 1000L;

    private ResultController() {
    }

    public static void printResult(int numLotto) {
        OutputView.printPreResult();

        List<MatchScore> msLst = MatchScore.getWinObjLst();

        for (MatchScore ms : msLst) {
            OutputView.printResult(makeResultDTOfromMS(ms));
        }
        OutputView.printYield(MatchScore.getTotalPrice() / (numLotto * PRICE_PER_LOTTO) * 100);
    }

    public static ResultDTO makeResultDTOfromMS(MatchScore ms) {
        return new ResultDTO(ms.getMatchNums(), ms.isMatchBonus(), ms.getPrice(), ms.getNumLotto());
    }
}
