package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentPartTest {

    private LottoView view;
    private PaymentPart subject;

    @BeforeEach
    void setUp() {
        view = mock(LottoView.class);
        subject = new PaymentPart(view);
    }

    @Test
    void handle() {
        int payment = 5000;
        when(view.showPaymentPrompt()).thenReturn(payment);

        int result = subject.handle();

        assertEquals(payment, result);
    }

    @Test
    void handle_cannotAffordOne() {
        int n = 3;
        AtomicInteger delta = new AtomicInteger(1 - n);
        when(view.showPaymentPrompt())
                .thenAnswer(invocation -> LottoTicket.PRICE + delta.getAndIncrement());

        int result = subject.handle();

        verify(view, times(n)).showPaymentPrompt();
        assertEquals(LottoTicket.PRICE, result);
    }
}
