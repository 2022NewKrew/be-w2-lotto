package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.validation.LessThanMinimumException;

public class PaymentPart {

    private final LottoView view;

    public PaymentPart(LottoView view) {
        this.view = view;
    }

    public int handle() {
        try {
            return getValidPayment();
        } catch (LessThanMinimumException e) {
            view.printLessThanMinimum(e.getMinimum());
            return handle();
        }
    }

    private int getValidPayment() {
        int minimum = LottoTicket.PRICE;
        int payment = view.showPaymentPrompt();
        if (payment < minimum) {
            throw new LessThanMinimumException(minimum);
        }
        return payment;
    }
}
