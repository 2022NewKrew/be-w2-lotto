package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("구매 금액은 음수가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-10_000, -1_000})
    void constructor_NegativeValue_Exception(int value) {
        assertThatThrownBy(() -> Money.of(value)).hasMessage("0보다 작은 값은 허용하지 않습니다.");
    }
}