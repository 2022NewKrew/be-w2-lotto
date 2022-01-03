import view.InputView;
import view.OutputView;

public class Main {
    private static final int FIRST = 2000000000;
    private static final int SECOND = 1500000;
    private static final int THIRD = 50000;
    private static final int FORTH = 5000;

    public static void main(String[] args) {
        int a = InputView.getNumLotto();
        OutputView.printLottoLine(InputView.getWinNumber());
        OutputView.printPreResult();
        OutputView.printResult(1, FIRST, 3);
        OutputView.printYield(30);
    }
}