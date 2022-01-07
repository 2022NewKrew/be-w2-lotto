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
            return getPayment();
        } catch (LessThanMinimumException e) {
            view.printLessThanMinimum(e.getMinimum());
            return handle();
        } catch (NumberFormatException e) {
            view.printNumberFormatError();
            return handle();
        }
    }

    private int getPayment() {
        int minimum = LottoTicket.PRICE;
        int payment = view.showPaymentPrompt();
        if (payment < minimum) {
            throw new LessThanMinimumException(minimum);
        }
        return payment;
    }
}
