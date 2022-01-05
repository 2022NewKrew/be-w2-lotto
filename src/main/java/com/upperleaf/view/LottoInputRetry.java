package com.upperleaf.view;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.lotto.LottoWinningNumber;

public class LottoInputRetry extends LottoInput {

    private final LottoInput lottoInput;

    public LottoInputRetry(LottoInput lottoInput) {
        this.lottoInput = lottoInput;
    }

    @Override
    public LottoPaymentInfo inputPaymentInfoByUser() {
        LottoPaymentInfo paymentInfo = null;
        while (paymentInfo == null) {
            paymentInfo = inputPaymentInternal();
        }
        return paymentInfo;
    }

    private LottoPaymentInfo inputPaymentInternal() {
        LottoPaymentInfo paymentInfo = null;
        try {
            paymentInfo = lottoInput.inputPaymentInfoByUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paymentInfo;
    }

    @Override
    public LottoWinningNumber inputWinningNumber() {
        LottoWinningNumber winningNumber = null;
        while(winningNumber == null) {
            winningNumber = inputWinningNumberInternal();
        }
        return winningNumber;
    }

    private LottoWinningNumber inputWinningNumberInternal() {
        LottoWinningNumber winningNumber = null;
        try {
             winningNumber = lottoInput.inputWinningNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return winningNumber;
    }
}
