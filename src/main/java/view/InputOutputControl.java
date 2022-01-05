package view;

import domain.LottoProgress;
import dto.PurchasedLottoDTO;
import dto.WinnigStatisticDTO;

public class InputOutputControl {
    private InputInformation inputInformation;
    private PrintOutput printOutput;
    private LottoProgress lottoProgress;

    private PurchasedLottoDTO purchasedLottoDTO;
    private WinnigStatisticDTO winnigStatisticDTO;

    public void run() {
        inputInformation = new InputInformation();
        printOutput = new PrintOutput();
        lottoProgress = new LottoProgress();

        viewPurchasedLotto();
        viewWinningStatistic();

    }

    private void viewPurchasedLotto() {
        purchasedLottoDTO = inputInformation.inputPurchaseAmount();
        purchasedLottoDTO = lottoProgress.buyingLotto(purchasedLottoDTO);
        printOutput.printPurchasedLotto(purchasedLottoDTO);
    }

    private void viewWinningStatistic() {
        winnigStatisticDTO = inputInformation.inputPrevWinningNumbers();
        winnigStatisticDTO = lottoProgress.calculateWinningStatistic(winnigStatisticDTO);
        printOutput.printWinnigStatistic(winnigStatisticDTO);
    }
}
