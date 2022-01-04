package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호 범위를 벗어날 경우 예외를 던진다.")
    @ValueSource(ints = {46, 0, -9999})
    void invalidNumber(int invalidLottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .isExactlyInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("로또 번호 범위 안일 경우 LottoNumber 객체를 생성해준다.")
    void validNumber() {
        int validLottoNumber = 8;
        assertThat(new LottoNumber(validLottoNumber))
                .isNotNull();
    }
}