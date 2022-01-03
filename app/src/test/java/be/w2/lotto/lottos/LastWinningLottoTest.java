package be.w2.lotto.lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LastWinningLottoTest {

    @Test
    @DisplayName("몇개가 내 로또와 일치하는지 여부 확인 -> 6개 일치")
    void getHowManyCorrect_6_Correct() {
        //Given
        List<Integer> numberOfLottos = Arrays.asList(5, 9, 38, 41, 43, 44);
        Lotto lotto = LottoTest.getInstance(numberOfLottos);
        LastWinningLotto lastWinningLotto = getInstance(numberOfLottos);

        //When
        int result = lastWinningLotto.getHowManyCorrect(lotto);

        //Then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("몇개가 내 로또와 일치하는지 여부 확인 -> 3개 일치")
    void getHowManyCorrect_3_Correct() {
        //Given
        List<Integer> numberOfLottos = Arrays.asList(13, 15, 18, 21, 46, 59);
        Lotto lotto = LottoTest.getInstance(numberOfLottos);

        List<Integer> numberOfLastWinningLotto = Arrays.asList(13, 14, 18, 21, 23, 35);
        LastWinningLotto lastWinningLotto = getInstance(numberOfLastWinningLotto);

        //When
        int result = lastWinningLotto.getHowManyCorrect(lotto);

        //Then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("몇개가 내 로또와 일치하는지 여부 확인 -> 1개 일치")
    void getHowManyCorrect_1_Correct() {
        //Given
        List<Integer> numberOfLottos = Arrays.asList(9, 17, 38, 41, 43, 44);
        Lotto lotto = LottoTest.getInstance(numberOfLottos);

        List<Integer> numberOfLastWinningLotto = Arrays.asList(17, 21, 29, 37, 42, 45);
        LastWinningLotto lastWinningLotto = getInstance(numberOfLastWinningLotto);

        //When
        int result = lastWinningLotto.getHowManyCorrect(lotto);

        //Then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("몇개가 내 로또와 일치하는지 여부 확인 -> 0개 일치")
    void getHowManyCorrect_0_Correct() {
        //Given
        List<Integer> numberOfLottos = Arrays.asList(5, 9, 38, 40, 59, 60);
        Lotto lotto = LottoTest.getInstance(numberOfLottos);


        List<Integer> numberOfLastWinningLotto = Arrays.asList(8, 21, 23, 41, 42, 43);
        LastWinningLotto lastWinningLotto = getInstance(numberOfLastWinningLotto);

        //When
        int result = lastWinningLotto.getHowManyCorrect(lotto);

        //Then
        assertEquals(0, result);
    }

    public static LastWinningLotto getInstance(List<Integer> numbers) {
        return new LastWinningLotto(numbers);
    }
}