package org.cs.finn.lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("중복된 LottoNumber가 List에 존재하면 예외를 발생시킨다")
    public void testDuplicateLottoNumberInList() {
        // given
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("List에 LottoNumber 개수가 " + LottoNumbers.SIZE +"개가 아니면 예외를 발생시킨다")
    public void testSizeInList() {
        // given
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
