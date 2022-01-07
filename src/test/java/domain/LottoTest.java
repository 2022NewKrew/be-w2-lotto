package domain;

import static org.assertj.core.api.Assertions.assertThat;

import exception.InvalidLottoLengthException;
import exception.InvalidLottoNumberException;
import org.junit.jupiter.api.Assertions;

//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LottoTest {

    @Test
    @DisplayName("로또 내에 넘버 포함 유무 확인")
    void contains() {
        // given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        // when & then
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    @DisplayName("로또 내에 길이 6개 exception 검증")
    void invalidLottoLengthException() {
        // given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        // when
        InvalidLottoLengthException thrown = Assertions.assertThrows(InvalidLottoLengthException.class, () -> {
            new Lotto(numbers);
        });

        // then
        Assertions.assertEquals("Lotto number has wrong length.", thrown.getMessage());
    }

    @Test
    @DisplayName("로또 내에 1~45 이외의 범위 exception 검증")
    void invalidLottoNumberRangeException() {
        // given
        Set<Integer> numbers1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 99));
        Set<Integer> numbers2 = new HashSet<>(Arrays.asList(0, 2, 3, 4, 5, 6));
        Set<Integer> numbers3 = new HashSet<>(Arrays.asList(-1, 2, 3, 4, 5, 6));

        // when
        InvalidLottoNumberException throw1 = Assertions.assertThrows(InvalidLottoNumberException.class, () -> {
            new Lotto(numbers1);
        });
        InvalidLottoNumberException throw2 = Assertions.assertThrows(InvalidLottoNumberException.class, () -> {
            new Lotto(numbers2);
        });
        InvalidLottoNumberException throw3 = Assertions.assertThrows(InvalidLottoNumberException.class, () -> {
            new Lotto(numbers3);
        });

        // then
        System.out.println(throw1.getMessage());
        Assertions.assertEquals("Lotto number has wrong range.", throw1.getMessage());
        Assertions.assertEquals("Lotto number has wrong range.", throw2.getMessage());
        Assertions.assertEquals("Lotto number has wrong range.", throw3.getMessage());
    }


}