import domain.MyLottoLines;
import manager.ResultManager;
import manager.StartManager;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        StartManager sm = new StartManager();
        OutputView.printLottoLine(sm.getWinningLine());

        MyLottoLines myLottoLines = new MyLottoLines(sm.getLottoLines());

        ResultManager.printResult(myLottoLines.getNumOfLotto(), myLottoLines.checkWinning(sm.getWinningLine()));
    }
}