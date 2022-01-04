package com.upperleaf;

import com.upperleaf.domain.*;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.view.LottoInput;
import com.upperleaf.view.LottosPrinter;

public class LottoApp {

    private static final int LOTTO_PRICE = 1000;

    private final LottoInput lottoInput = new LottoInput();
    private final LottosPrinter lottosPrinter = new LottosPrinter();
    private final LottoSeller lottoSeller = new LottoSeller(LOTTO_PRICE);

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
        LottoStatistics statistics = new LottoStatistics(new LottoMatcher(lottos, winningNumber));

        lottosPrinter.printResults(statistics);
        lottosPrinter.printProfit(statistics, lottoPaymentInfo);
    }
}
