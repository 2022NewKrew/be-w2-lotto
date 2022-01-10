package controller;


import DTO.ResultDTO;
import domain.MatchStore;
import domain.WinningClassifier;

    private ResultController() {
        throw new AssertionError();
    }

    public static void printResult(MatchStore matchStore) {
        List<WinningClassifier> gradeLst = WinningClassifier.getWinObjLst();

        for (WinningClassifier grade : gradeLst) {
            OutputView.printResult(makeResultDTOFromGrade(grade, matchStore.getCnt(grade)));
        }
    }

    public static void printPreResult() {
        OutputView.printPreResult();
    }

    public static void printYield(float yield) {
        OutputView.printYield(yield);
    }

    public static ResultDTO makeResultDTOFromGrade(WinningClassifier ms, int numLotto) {
        return new ResultDTO(ms.getMatchNums(), ms.isMatchBonus(), ms.getPrice(), numLotto);
    }
}
