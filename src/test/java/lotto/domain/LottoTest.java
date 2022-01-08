package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private static final int CREATED_SIZE = 6;

    @Test
    @DisplayName("로또 생성시 6개의 숫자를 생성하는지")
    void test1() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(CREATED_SIZE);
    }

    @Test
    @DisplayName("로또 생성시 6개가 아니면 에러를 발생시키는지")
    void test1Exception() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("1~45의 숫자가 아니면 에러를 발생시키는지")
    void test2() {
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("중복되는 숫자가 있으면 에러를 발생시키는지")
    void test3() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers));
    }

}