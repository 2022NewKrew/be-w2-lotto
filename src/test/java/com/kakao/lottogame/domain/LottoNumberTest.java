package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("유효하지 않은 숫자는 선택할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void constructor_InvalidNumber_Exception(int value) {
        assertThatThrownBy(() -> LottoNumber.of(value)).hasMessage("1부터 45까지의 숫자를 선택할 수 있습니다.");
    }

    @DisplayName("유효한 숫자는 선택할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void constructor_ValidNumber_Success(int value) {
        assertThat(LottoNumber.of(value).getValue()).isEqualTo(value);
    }
}