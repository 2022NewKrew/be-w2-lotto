package lotto.manager;

import lotto.domain.LottoChecker;
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

    private LottoChecker lottoChecker;

    private List<Lotto> lottoList;
    private LottoResult lottoResult;

    private int money;

    private LottoManager() {
        customScanner = new CustomScanner();
        lottoCliView = LottoCliView.getInstance();
        lottoChecker = LottoChecker.getInstance();
    }

    public static LottoManager getInstance() {
        return INSTANCE;
    }

    private void purchaseLotto() {
        try {
            lottoCliView.printMessage(LottoMessage.INPUT_MONEY.toString());
            money = customScanner.readInt();
        } catch (NumberFormatException e) {
            lottoCliView.printMessage(e.getMessage());
            purchaseLotto();
        }
    }

    private void printPurchasedLotto() {
        lottoList = new ArrayList<>();
        int remainingMoney = money;
        while (remainingMoney / 1000 > 0) {
            lottoList.add(new Lotto());
            remainingMoney -= 1000;
        }
        lottoCliView.printMessage(lottoList.size() + LottoMessage.INPUT_MONEY_SUCCESS.toString());
        lottoCliView.printLottoList(lottoList);
        lottoCliView.printMessage("");
    }

    private void initializeLottoChecker() {
        try {
            lottoCliView.printMessage(LottoMessage.INPUT_WINNING_NUMBERS.toString());
            List<Integer> numbers = customScanner.readCommaSeparatedInt();
            lottoCliView.printMessage(LottoMessage.INPUT_BONUS_NUMBER.toString());
            int bonusNumber = customScanner.readInt();
            lottoChecker.init(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeLottoChecker();
        }
    }

    public void run() {
        purchaseLotto();
        printPurchasedLotto();
        initializeLottoChecker();
        lottoResult = lottoChecker.checkAll(lottoList);
        lottoCliView.printLottoResult(lottoResult);
        lottoCliView.printEarningsRate(lottoResult.getEarningsRate(money));
    }
}
