package view.console;

import controller.ConsoleController;
import dto.request.LottoPurchaseDTO;
import dto.response.PurchasedLottoDTO;
import util.console.input.BudgetInputInterface;
import util.console.input.ManualInputInterface;
import util.console.input.ManualNumbersInputInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchaseView implements ConsoleView {
    private final ConsoleController consoleController;

    private final BudgetInputInterface budgetInputInterface = new BudgetInputInterface();
    private final ManualInputInterface manualInputInterface = new ManualInputInterface();
    private final ManualNumbersInputInterface manualNumbersInputInterface = new ManualNumbersInputInterface();

    public LottoPurchaseView(ConsoleController consoleController) {
        this.consoleController = consoleController;
    }

    @Override
    public void print() throws Exception {
        final LottoPurchaseDTO lottoPurchaseDTO = inputLottoPurchase();

        PurchasedLottoDTO purchasedLottoDTO = consoleController.purchase(lottoPurchaseDTO);

        saveCacheOfLottoId(purchasedLottoDTO);

        System.out.println(purchasedLottoDTO.getLotto());
    }

    private LottoPurchaseDTO inputLottoPurchase() {
        final int budget = budgetInputInterface.read();
        final int numberOfManualLotto = manualInputInterface.read();
        final List<List<Integer>> manualLottoNumbers =
                IntStream.range(0, numberOfManualLotto)
                        .mapToObj(number -> manualNumbersInputInterface.read())
                        .collect(Collectors.toList());

        return new LottoPurchaseDTO(budget, numberOfManualLotto, manualLottoNumbers);
    }

    private void saveCacheOfLottoId(PurchasedLottoDTO purchasedLottoDTO) {
        setAttribute(lottoId, purchasedLottoDTO.getId());
    }
}
