package lotto;

import lotto.controller.LottoSimulator;
import lotto.view.LottoInputScannerOnConsole;
import lotto.view.LottoOutputPrinterOnConsole;

public class LottoMainOnConsole {

    public static void main(String[] args) {
        LottoSimulator lottoSimulator = new LottoSimulator(new LottoInputScannerOnConsole(),
            new LottoOutputPrinterOnConsole());
        lottoSimulator.start();
    }
}
