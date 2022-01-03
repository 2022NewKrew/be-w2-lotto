package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.DuplicatedLottoNumberException;
import com.chanminkim.w2.exception.InvalidLottoNumbersLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("주어진 로또 번호가 6개가 아닐 경우 예외를 던진다.")
    void invalidLottoNumbers() {
        assertThatThrownBy(() -> new Lotto.Builder()
                .add(new LottoNumber(3))
                .add(new LottoNumber(22))
                .add(new LottoNumber(34))
                .build()
        ).isExactlyInstanceOf(InvalidLottoNumbersLengthException.class);
    }

    @Test
    @DisplayName("주어진 로또 번호에 중복된 번호가 있을 경우 예외를 던진다.")
    void duplicatedLottoNumbers() {
        assertThatThrownBy(() -> new Lotto.Builder()
                .add(new LottoNumber(3))
                .add(new LottoNumber(3))
                .add(new LottoNumber(34))
                .add(new LottoNumber(27))
                .add(new LottoNumber(8))
                .add(new LottoNumber(6))
                .build()
        ).isExactlyInstanceOf(DuplicatedLottoNumberException.class);
    }

    @Test
    @DisplayName("랜덤하게 로또를 생성 가능해야 한다.")
    void createLottoRandomly() {
        assertThat(new Lotto.Builder().buildRandomly())
                .isNotNull();
    }

    @Test
    @DisplayName("주어진 번호로 로또를 생성 가능해야 한다.")
    void createLotto() {
        Lotto lotto = new Lotto.Builder()
                .add(new LottoNumber(11))
                .add(new LottoNumber(3))
                .add(new LottoNumber(34))
                .add(new LottoNumber(27))
                .add(new LottoNumber(8))
                .add(new LottoNumber(6))
                .build();
        assertThat(lotto)
                .isNotNull();
        System.out.println(lotto);
    }
}