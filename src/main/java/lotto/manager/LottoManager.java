package lotto.manager;

import lotto.domain.WinningLotto;
import lotto.domain.constant.LottoMessage;
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

    private WinningLotto winningLotto;

    private List<Lotto> lottoList;
    private LottoResult lottoResult;

    private int money;
    int remainingMoney;
    private int manualAmount;

    private LottoManager() {
        customScanner = new CustomScanner();
        lottoCliView = LottoCliView.getInstance();
        lottoList = new ArrayList<>();
    }

    public static LottoManager getInstance() {
        return INSTANCE;
    }

    private void getMoney() {
        try {
            lottoCliView.printMessage(LottoMessage.INPUT_MONEY.toString());
            remainingMoney = money = customScanner.readInt();
        } catch (NumberFormatException e) {
            lottoCliView.printMessage(e.getMessage());
            getMoney();
        }
    }

    private void getManualAmount() {
        try {
            lottoCliView.printMessage(LottoMessage.INPUT_MANUAL_AMOUNT.toString());
            manualAmount = customScanner.readInt();
            // TODO: 수동으로 구매할 로또 수 검증(투입금액으로 살 수 있는지)
        } catch (NumberFormatException e) {
            lottoCliView.printMessage(e.getMessage());
            getManualAmount();
        }
    }

    private void manualPurchaseAllLotto() {
        lottoCliView.printMessage(LottoMessage.INPUT_MANUAL_NUMBERS.toString());
        for (int i = 0; i < manualAmount && remainingMoney / 1000 > 0; i++) {
            manualPurchaseLotto();

        }
    }

    private void manualPurchaseLotto() {
        List<Integer> numbers = customScanner.readCommaSeparatedInt();
        try {
            lottoList.add(new Lotto(numbers));
            remainingMoney -= 1000;
        } catch (IllegalArgumentException e) {
            lottoCliView.printMessage(e.getMessage());
            manualPurchaseLotto();
        }
    }

    private void purchaseAutomaticLotto() {
        while (remainingMoney / 1000 > 0) {
            lottoList.add(new Lotto());
            remainingMoney -= 1000;
        }
    }

    private void showPurchasedResults() {
        lottoCliView.printMessage(String.format(
                LottoMessage.INPUT_MONEY_SUCCESS.toString(),
                manualAmount,
                lottoList.size() - manualAmount
        ));
        lottoCliView.printLottoList(lottoList);
        lottoCliView.printMessage("");
    }

    private void initializeLottoChecker() {
        try {
            lottoCliView.printMessage(LottoMessage.INPUT_WINNING_NUMBERS.toString());
            List<Integer> numbers = customScanner.readCommaSeparatedInt();
            lottoCliView.printMessage(LottoMessage.INPUT_BONUS_NUMBER.toString());
            int bonusNumber = customScanner.readInt();
            winningLotto = new WinningLotto(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeLottoChecker();
        }
    }

    public void run() {
        getMoney();
        getManualAmount();
        manualPurchaseAllLotto();
        purchaseAutomaticLotto();
        showPurchasedResults();
        initializeLottoChecker();
        lottoResult = winningLotto.checkAll(lottoList);
        lottoCliView.printLottoResult(lottoResult);
        lottoCliView.printEarningsRate(lottoResult.getEarningsRate(money));
    }
}
