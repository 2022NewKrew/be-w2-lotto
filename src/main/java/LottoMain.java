import domain.Lotto;
import domain.LottoService;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LottoService lottoService = new LottoService(money);
        List<Lotto> lottos = lottoService.getLottos();

        ResultView.printPurchaseResult(lottos);
    }
}
