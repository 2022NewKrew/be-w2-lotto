package com.upperleaf.domain;

public class LottoPaymentInfo {

    private final long paymentAmount;
    private final int manualNum;

    /**
     * 로또 지불 정보
     * @param paymentAmount 사용자가 로또를 사기위해 지불한 금액
     */
    public LottoPaymentInfo(long paymentAmount, int manualNum) {
        validation(paymentAmount, manualNum);
        this.paymentAmount = paymentAmount;
        this.manualNum = manualNum;
    }

    public long getPaymentAmount() {
        return paymentAmount;
    }

    public int getManualNum() {
        return manualNum;
    }

    private void validation(long paymentAmount, int manualNum) {
        if(paymentAmount < 0 || manualNum < 0) {
            throw new IllegalArgumentException("로또 지불 값 또는 수동 개수는 음수 일 수 없습니다.");
        }
    }
}
