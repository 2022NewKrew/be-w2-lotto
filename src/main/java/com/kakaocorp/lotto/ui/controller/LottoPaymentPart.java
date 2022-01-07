package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoPaymentPartView;
import com.kakaocorp.lotto.validation.LessThanMinimumException;

public class LottoPaymentPart extends LottoControllerPart<LottoPaymentPartView> {

    public LottoPaymentPart(LottoPaymentPartView view) {
        super(view);
    }

    public int handle() {
        return getValidValue(this::getPayment);
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
