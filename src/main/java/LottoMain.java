import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        int money = InputView.getMoney();

        int manualLottoCount = InputView.getManualLottoCount();
        List<List<Integer>> manualNumbers = InputView.getManualLottoNumbers(manualLottoCount);
        System.out.println(manualNumbers.toString());

        List<Lotto> lottos = LottoService.buyLottos(money, manualLottoCount, manualNumbers);

        ResultView.printPurchaseResult(lottos, manualLottoCount);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNum = InputView.getBounusNum();

        Results results = new Results(lottos, winningNumbers, bonusNum);

        ResultView.printResult(results);
        ResultView.printROI(results, money);
    }
}
