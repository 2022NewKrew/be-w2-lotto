package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.DuplicatedLottoNumberException;
import com.chanminkim.w2.exception.InvalidLottoNumbersLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("주어진 로또 번호가 6개가 아닐 경우 예외를 던진다.")
    void invalidLottoNumbers() {
        List<Integer> invalidLottoNumbers = Arrays.asList(3, 22, 34);
        assertThatThrownBy(() -> new Lotto(invalidLottoNumbers))
                .isExactlyInstanceOf(InvalidLottoNumbersLengthException.class);
    }

    @Test
    @DisplayName("주어진 로또 번호에 중복된 번호가 있을 경우 예외를 던진다.")
    void duplicatedLottoNumbers() {
        List<Integer> duplicatedLottoNumbers = Arrays.asList(3, 3, 34, 27, 8, 6);
        assertThatThrownBy(() -> new Lotto(duplicatedLottoNumbers))
                .isExactlyInstanceOf(DuplicatedLottoNumberException.class);
    }

    @Test
    @DisplayName("랜덤하게 로또를 생성 가능해야 한다.")
    void createLottoRandomly() {
        Lotto randomLotto = RandomLottoGenerator.generateLotto();
        assertThat(randomLotto)
                .isNotNull();
        System.out.println(randomLotto);
    }

    @Test
    @DisplayName("주어진 번호로 로또를 생성 가능해야 한다.")
    void createLotto() {
        List<Integer> validLottoNumbers = Arrays.asList(11, 3, 34, 27, 8, 6);
        Lotto lotto = new Lotto(validLottoNumbers);
        assertThat(lotto)
                .isNotNull();
        System.out.println(lotto);
    }
}