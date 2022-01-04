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
        LottoService lottoService = new LottoService(money);
        List<Lotto> lottos = lottoService.getLottos();

        ResultView.printPurchaseResult(lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNum = InputView.getBounusNum();
        ResultGenerator resultGenerator = new ResultGenerator();
        List<Result> results = resultGenerator.generate(lottos, winningNumbers, bonusNum);

        ResultView.printWinningResult(results, money);

    }
}
