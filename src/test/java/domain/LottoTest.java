package domain;

import static org.assertj.core.api.Assertions.assertThat;

import exception.InvalidLottoLengthException;
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
}