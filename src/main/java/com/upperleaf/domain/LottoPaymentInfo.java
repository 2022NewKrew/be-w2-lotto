package com.upperleaf.domain;

public class LottoPaymentInfo {

    private final long paymentAmount;

    /**
     * 로또 지불 정보
     * @param paymentAmount 사용자가 로또를 사기위해 지불한 금액
     */
    public LottoPaymentInfo(long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public long getPaymentAmount() {
        return paymentAmount;
    }
}
