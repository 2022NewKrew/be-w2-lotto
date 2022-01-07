package controller;

import DTO.ResultDTO;
import domain.MatchStore;
import domain.WinningClassifier;
import view.OutputView;

import java.util.List;

public class ResultController {
    private ResultController() {
    }

    public static void printResult(MatchStore matchStore) {
        List<WinningClassifier> msLst = WinningClassifier.getWinObjLst();

        for (WinningClassifier grade : msLst) {
            OutputView.printResult(makeResultDTOFromGrade(grade, matchStore.getCnt(grade)));
        }
    }

    public static void printPreResult() {
        OutputView.printPreResult();
    }

    public static void printYield(long yield) {
        OutputView.printYield(yield);
    }

    public static ResultDTO makeResultDTOFromGrade(WinningClassifier ms, int numLotto) {
        return new ResultDTO(ms.getMatchNums(), ms.isMatchBonus(), ms.getPrice(), numLotto);
    }
}
