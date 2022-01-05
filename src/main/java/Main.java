import controller.ResultController;
import controller.StartController;
import domain.MyLottoLines;

public class Main {
    public static void main(String[] args) {
        StartController sm = new StartController();

        MyLottoLines myLottoLines = sm.getLottoLines();
        myLottoLines.checkWinning(sm.getWinningLine(), sm.getBonus());

        ResultController.printResult(myLottoLines.getNumLotto());
    }
}
