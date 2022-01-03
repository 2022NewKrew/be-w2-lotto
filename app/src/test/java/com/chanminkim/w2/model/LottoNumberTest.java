package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 범위를 벗어날 경우 예외를 던진다. (1)")
    void invalidNumber1() {
        int invalidLottoNumber = 46;
        assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .isExactlyInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 벗어날 경우 예외를 던진다. (2)")
    void invalidNumber2() {
        int invalidLottoNumber = 0;
        assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .isExactlyInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 벗어날 경우 예외를 던진다. (3)")
    void invalidNumber3() {
        int invalidLottoNumber = -9999;
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