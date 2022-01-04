import controller.ResultController;
import controller.StartController;
import domain.MyLottoLines;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        StartController sm = new StartController();

        MyLottoLines myLottoLines = sm.getLottoLines();

        ResultController.printResult(myLottoLines.getNumOfLotto(), myLottoLines.checkWinning(sm.getWinningLine()));
    }
}
