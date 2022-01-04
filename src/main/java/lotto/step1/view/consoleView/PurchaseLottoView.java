package lotto.step1.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.util.consoleInput.PurchaseAmountInputConsole;

public class PurchaseLottoView implements ConsoleView {
    private final LottoController lottoController;
    private final InputConsole<Integer> purchaseAmountInputConsole = new PurchaseAmountInputConsole();

    public PurchaseLottoView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void print() throws ConsoleInputCountExceededException {
        final LottoPurchaseSheetDTO lottoPurchaseSheet = inputLottoPurchaseSheet();

        final PurchasedLottoDTO purchasedLotto = lottoController.purchase(lottoPurchaseSheet);

        saveLottoIdFromConsoleTempMemory(purchasedLotto);

        System.out.println(purchasedLotto);
    }

    private void saveLottoIdFromConsoleTempMemory(PurchasedLottoDTO lottoNumbersListDTO) {
        setAttributes(LOTTO_ID, String.valueOf(lottoNumbersListDTO.getId()));
    }

    private LottoPurchaseSheetDTO inputLottoPurchaseSheet() throws ConsoleInputCountExceededException {
        final int purchaseAmount = purchaseAmountInputConsole.read();

        return new LottoPurchaseSheetDTO(purchaseAmount);
    }
}
