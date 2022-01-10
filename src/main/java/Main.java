import controller.ResultController;
import controller.StartController;
import domain.MatchStore;
import domain.MyLottoLines;
import domain.WinningLottoLine;

public class Main {
    public static void main(String[] args) {
        MyLottoLines myLottoLines = new MyLottoLines();
        int numLotto = StartController.inputNumLotto();
        int numManLotto = StartController.inputNumManualLotto(numLotto);

        StartController.addManualLottoLines(myLottoLines, numManLotto);
        StartController.addAutoLottoLines(myLottoLines, numLotto - numManLotto);
        StartController.printPurchaseSummary(numManLotto, numLotto - numManLotto);

        WinningLottoLine winningLottoLine = StartController.makeWinningLine();

        MatchStore matchStore = new MatchStore();
        myLottoLines.checkWinning(matchStore, winningLottoLine.getLottoLine(), winningLottoLine.getBonusList());

        printResult(matchStore);
    }

    private static void printResult(MatchStore matchStore) {
        ResultController.printPreResult();

        ResultController.printResult(matchStore);

        ResultController.printYield(matchStore.getYield());
    }
}
