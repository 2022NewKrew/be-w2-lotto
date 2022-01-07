import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        int money = InputView.getMoney();

        int manualLottoCount = InputView.getManualLottoCount();
        List<List<LottoNumber>> manualNumbers = InputView.getManualLottoNumbers(manualLottoCount);

        List<Lotto> lottos = LottoService.buyLottos(money, manualLottoCount, manualNumbers);

        ResultView.printPurchaseResult(lottos, manualLottoCount);

        List<LottoNumber> winningNumbers = InputView.getWinningNumbers();
        LottoNumber bonusNum = InputView.getBounusNum();

        Results results = new Results(lottos, winningNumbers, bonusNum);

        ResultView.printResult(results);
        ResultView.printROI(results, money);
    }
}
