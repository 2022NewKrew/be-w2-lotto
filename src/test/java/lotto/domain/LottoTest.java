package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호를 잘 출력하는가")
    void printNumberList() {
        //given
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numberList);

        //when
        String result = lotto.printNumberList();

        //then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");

    }

    @Test
    @DisplayName("로또 번호 중 당첨 숫자의 개수를 잘 반환하는가")
    void checkLotto() {
        //given
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numberList);
        List<Integer> winningNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));

        //when
        int matchingNumber = lotto.checkLotto(winningNumberList);

        //then
        assertThat(matchingNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호의 유무를 잘 반환하는가")
    void hasBonusNumber() {
        //given
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numberList);
        int bonusNumber = 6;

        //when
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        //then
        assertThat(hasBonusNumber).isEqualTo(true);
    }
}