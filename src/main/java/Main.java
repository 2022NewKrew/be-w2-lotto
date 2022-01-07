import controller.ResultController;
import controller.StartController;
import domain.MatchStore;
import domain.MyLottoLines;
import domain.WinningLottoLine;

public class Main {
    public static void main(String[] args) {
        int numLotto = StartController.inputNumLotto();
        MyLottoLines myLottoLines = new MyLottoLines();

        StartController.addLottoLines(myLottoLines, numLotto);

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
