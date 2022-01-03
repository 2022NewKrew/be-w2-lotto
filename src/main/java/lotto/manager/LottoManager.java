package lotto.manager;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.util.CustomScanner;
import lotto.view.LottoCliView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private static final LottoManager INSTANCE = new LottoManager();

    private CustomScanner customScanner;
    private LottoCliView lottoCliView;

    private int money;
    private List<Lotto> lottoList;
    LottoResult lottoResult;

    private LottoManager() {
        customScanner = new CustomScanner();
        lottoCliView = LottoCliView.getInstance();
    }

    public static LottoManager getInstance() {
        return INSTANCE;
    }

    private void purchaseLotto(int money) {
        lottoList = new ArrayList<>();
        while (money / 1000 > 0) {
            lottoList.add(new Lotto());
            money -= 1000;
        }
        lottoCliView.printMessage(lottoList.size() + "개를 구매했습니다.");
        lottoCliView.printLottoList(lottoList);
        lottoCliView.printMessage("");
    }

    public void run() {
        money = customScanner.getMoney();
        purchaseLotto(money);
        lottoResult = new LottoResult(customScanner.getWinningNumbers());
        lottoList.forEach(lottoResult::countNumberOfMatches);
        lottoCliView.printLottoResult(lottoResult);
        lottoCliView.printEarningsRate(lottoResult.getEarningsRate(money));
    }
}
