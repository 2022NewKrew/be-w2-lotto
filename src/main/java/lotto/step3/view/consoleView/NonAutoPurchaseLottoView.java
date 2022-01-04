package lotto.step3.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.util.consoleInput.PurchaseAmountInputConsole;
import lotto.step1.view.consoleView.ConsoleView;
import lotto.step3.dto.request.NoAutoLottoPurchaseSheetDTO;
import lotto.step3.util.consoleInput.LottoNumbersListInputConsole;
import lotto.step3.util.consoleInput.LottoNumbersListNoMsgInputConsole;
import lotto.step3.util.consoleInput.NumOfNonAutoInputConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NonAutoPurchaseLottoView implements ConsoleView {
    private final LottoController lottoController;
    private final InputConsole<Integer> purchaseAmountInputConsole = new PurchaseAmountInputConsole();
    private final InputConsole<Integer> numOfNonAutoInputConsole = new NumOfNonAutoInputConsole();
    private final InputConsole<List<Integer>> lottoNumbersInputConsole = new LottoNumbersListInputConsole();
    private final InputConsole<List<Integer>> lottoNumbersNoMsgInputConsole = new LottoNumbersListNoMsgInputConsole();

    public NonAutoPurchaseLottoView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void print() throws ConsoleInputCountExceededException {
        final LottoPurchaseSheetDTO lottoPurchaseSheet = inputLottoPurchaseSheetDTO();

        final PurchasedLottoDTO purchasedLotto = lottoController.purchase(lottoPurchaseSheet);

        saveLottoIdFromConsoleTempMemory(purchasedLotto);

        System.out.println(purchasedLotto);
    }

    private LottoPurchaseSheetDTO inputLottoPurchaseSheetDTO() {
        final int purchaseAmount = purchaseAmountInputConsole.read();
        final int numOfNonAuto = getNumOfNonAuto(purchaseAmount);
        final List<List<Integer>> lottoNumbersList = getLottoNumbersListNoAuto(numOfNonAuto);

        return new NoAutoLottoPurchaseSheetDTO(purchaseAmount, lottoNumbersList);
    }

    private int getNumOfNonAuto(int purchaseAmount) {
        int numOfNonAuto = numOfNonAutoInputConsole.read();
        while (numOfNonAuto > purchaseAmount) {
            System.out.println("구매 금액보다 더 적은 횟수를 입력해주세요.");
            numOfNonAuto = numOfNonAutoInputConsole.read();
        }
        return numOfNonAuto;
    }

    private List<List<Integer>> getLottoNumbersListNoAuto(int numOfNonAuto) {
        final List<List<Integer>> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbersInputConsole.read());
        IntStream.range(0, numOfNonAuto - 1).forEach(i -> lottoNumbersList.add(lottoNumbersNoMsgInputConsole.read()));
        return lottoNumbersList;
    }

    private void saveLottoIdFromConsoleTempMemory(PurchasedLottoDTO lottoNumbersListDTO) {
        setAttributes(LOTTO_ID, String.valueOf(lottoNumbersListDTO.getId()));
    }
}
