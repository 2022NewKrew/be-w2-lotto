package com.kakaocorp.lotto.ui;

public class PaymentPart {

    private final LottoView view;

    public PaymentPart(LottoView view) {
        this.view = view;
    }

    public int handle() {
        return view.showPaymentPrompt();
    }
}
