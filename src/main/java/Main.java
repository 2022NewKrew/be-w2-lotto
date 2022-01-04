import domain.MyLottoLines;
import manager.StartManager;
import view.OutputView;

import java.util.List;

public class Main {
    private static final int FIRST = 2000000000;
    private static final int SECOND = 1500000;
    private static final int THIRD = 50000;
    private static final int FORTH = 5000;

    public static void main(String[] args) {
        StartManager sm = new StartManager();
        OutputView.printLottoLine(sm.getWinningLine());

        MyLottoLines myLottoLines = new MyLottoLines(sm.getLottoLines());
        List<Integer> matchNumLst = myLottoLines.checkWinning(sm.getWinningLine());
        System.out.println(matchNumLst.toString());

        OutputView.printPreResult();
        OutputView.printResult(1, FIRST, 3);
        OutputView.printYield(30);
    }
}