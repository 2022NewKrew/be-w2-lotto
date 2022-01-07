package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoPaymentPartView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentPartTest {

    @Test
    void handle() {
        int payment = 5000;
        LottoPaymentPartView view = new StubView(() -> payment);
        LottoPaymentPart subject = new LottoPaymentPart(view);

        int result = subject.handle();

        assertEquals(payment, result);
    }

    @Test
    void handle_cannotAffordOne() {
        int n = 3;
        AtomicInteger delta = new AtomicInteger(1 - n);
        LottoPaymentPartView view = StubView.spy(() -> LottoTicket.PRICE + delta.getAndIncrement());
        LottoPaymentPart subject = new LottoPaymentPart(view);

        int result = subject.handle();

        verify(view, times(n)).showPaymentPrompt();
        assertEquals(LottoTicket.PRICE, result);
    }

    private static class StubView implements LottoPaymentPartView {

        private final IntSupplier paymentSupplier;

        public static StubView spy(IntSupplier paymentSupplier) {
            StubView view = new StubView(paymentSupplier);
            return Mockito.spy(view);
        }

        private StubView(IntSupplier paymentSupplier) {
            this.paymentSupplier = paymentSupplier;
        }

        @Override
        public void printLessThanMinimum(int minimum) {}
        @Override
        public void printGreaterThanMaximum(int maximum) {}
        @Override
        public void printDuplicateNotAllowed() {}
        @Override
        public void printValueNotAllowed(int value) {}
        @Override
        public void printWrongSize(int expected) {}
        @Override
        public void printNumberFormatError() {}

        @Override
        public int showPaymentPrompt() {
            return paymentSupplier.getAsInt();
        }
    }
}
