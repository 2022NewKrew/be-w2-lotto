package com.upperleaf;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.LottoWinningNumber;
import com.upperleaf.domain.Lottos;
import com.upperleaf.view.LottoInput;
import com.upperleaf.view.LottoResults;
import com.upperleaf.view.LottosPrinter;

public class LottoApp {

    private static final int LOTTO_PRICE = 1000;

    private final LottoInput lottoInput;
    private final LottosPrinter lottosPrinter;
    private final LottoSeller lottoSeller;

    LottoApp() {
        lottoInput = new LottoInput();
        lottosPrinter = new LottosPrinter();
        lottoSeller = new LottoSeller(LOTTO_PRICE);

    }

    public static void main(String[] args) {
        LottoApp app = new LottoApp();
        app.start();
    }

    /**
     * 로또 Application 실행 함수
     */
    public void start() {
        LottoPaymentInfo lottoPaymentInfo = lottoInput.inputPaymentInfoByUser();
        Lottos lottos = lottoSeller.sell(lottoPaymentInfo);
        lottosPrinter.printLottos(lottos);

        LottoWinningNumber winningNumber = lottoInput.inputWinningNumber();
        lottosPrinter.printResultsAndProfit(lottoPaymentInfo, new LottoResults(winningNumber, lottos));
    }
}
