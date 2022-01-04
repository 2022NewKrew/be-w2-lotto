import domain.MyLottoLines;
import controller.ResultController;
import controller.StartController;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        StartController sm = new StartController();
        OutputView.printLottoLine(sm.getWinningLine());

        MyLottoLines myLottoLines = new MyLottoLines(sm.getLottoLines());

        ResultController.printResult(myLottoLines.getNumOfLotto(), myLottoLines.checkWinning(sm.getWinningLine()));
    }
}