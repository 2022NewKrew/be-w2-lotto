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
        OutputView.printPreResult();

        List<WinningClassifier> msLst = WinningClassifier.getWinObjLst();

        for (WinningClassifier grade : msLst) {
            OutputView.printResult(makeResultDTOFromGrade(grade, matchStore.getCnt(grade)));
        }
        OutputView.printYield(matchStore.getYield());
    }

    public static ResultDTO makeResultDTOFromGrade(WinningClassifier ms, int numLotto) {
        return new ResultDTO(ms.getMatchNums(), ms.isMatchBonus(), ms.getPrice(), numLotto);
    }
}
