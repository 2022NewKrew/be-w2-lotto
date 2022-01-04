package controller;

import exception.LottoPurchasePriceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void 가격1000원보다작을때() {
        Assertions.assertThatThrownBy(() -> new LottoController(999)).isInstanceOf(LottoPurchasePriceException.class);
    }
}