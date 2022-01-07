package lotto.manager;

import lotto.domain.constant.LottoMessage;
import lotto.service.LottoService;
import lotto.util.CustomScanner;
import lotto.view.LottoConsoleView;

import java.util.List;

public class LottoConsoleManager implements LottoManager {
    private static final LottoConsoleManager INSTANCE = new LottoConsoleManager();

    private final LottoService service;
    private final LottoConsoleView view;
    private final CustomScanner customScanner;

    private LottoConsoleManager() {
        service = new LottoService();
        view = new LottoConsoleView();
        customScanner = new CustomScanner();
    }

    public static LottoConsoleManager getInstance() {
        return INSTANCE;
    }

    // Console IO
    private void getMoney() {
        try {
            view.printMessage(LottoMessage.INPUT_MONEY.toString());
            service.initializeMoney(customScanner.readLong());
        } catch (NumberFormatException e) {
            view.printMessage(e.getMessage());
            getMoney();
        }
    }

    // Console IO
    private void getManualAmount() {
        try {
            view.printMessage(LottoMessage.INPUT_MANUAL_AMOUNT.toString());
            service.initializeManualAmount(customScanner.readLong());
            // TODO: 수동으로 구매할 로또 수 검증(투입금액으로 살 수 있는지)
        } catch (NumberFormatException e) {
            view.printMessage(e.getMessage());
            getManualAmount();
        }
    }

    private void purchaseAllManualLotto() {
        view.printMessage(LottoMessage.INPUT_MANUAL_NUMBERS.toString());
        for (int i = 0; i < service.getManualAmount() && service.enoughMoney(); i++) {
            purchaseManualLotto();
        }
    }

    // Logic
    private void purchaseManualLotto() {
        List<Long> numbers = customScanner.readCommaSeparatedLong();
        try {
            service.purchaseManualLotto(numbers);
        } catch (IllegalArgumentException e) {
            view.printMessage(e.getMessage());
            purchaseManualLotto();
        }
    }

    private void purchaseAutomaticLotto() {
        service.purchaseAllAutomaticLotto();
    }

    private void showPurchasedResults() {
        view.printMessage(String.format(
                LottoMessage.INPUT_MONEY_SUCCESS.toString(),
                service.getManualAmount(),
                service.getAutomaticAmount()
        ));
        view.printLottoList(service.getLottoList()); //TODO: DTO 사용하도록 변경
        view.printMessage("");
    }

    private void initializeLottoChecker() {
        try {
            view.printMessage(LottoMessage.INPUT_WINNING_NUMBERS.toString());
            List<Long> numbers = customScanner.readCommaSeparatedLong();
            view.printMessage(LottoMessage.INPUT_BONUS_NUMBER.toString());
            long bonusNumber = customScanner.readLong();
            service.createWinningLotto(numbers, bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            initializeLottoChecker();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeLottoChecker();
        }
    }

    private void showLottoResults() {
        view.printLottoResult(service.getLottoResult());
        view.printEarningsRate(service.getEarningsPercent());
    }

    public void run() {
        getMoney();
        getManualAmount();
        purchaseAllManualLotto();
        purchaseAutomaticLotto();
        showPurchasedResults();
        initializeLottoChecker();
        service.checkAllLotto();
        showLottoResults();
    }
}
