import domain.Lotto;
import domain.LottoService;
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
        Map<Integer, Integer> winningResult = lottoService.getWinningResult(winningNumbers);

        ResultView.printWinningResult(winningResult, money);
    }
}
