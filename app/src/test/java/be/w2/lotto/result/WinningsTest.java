package be.w2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WinningsTest {

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 0개, 존재하지 않음")
    void getWinningsByHowManyCorrect_0() {
        //Given
        int howManyCorrect = 0;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 1개, 존재하지 않음")
    void getWinningsByHowManyCorrect_1() {
        //Given
        int howManyCorrect = 1;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 2개, 존재하지 않음")
    void getWinningsByHowManyCorrect_2() {
        //Given
        int howManyCorrect = 2;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 3개, 존재")
    void getWinningsByHowManyCorrect_3() {
        //Given
        int howManyCorrect = 3;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertEquals(Winnings.THREE, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 4개, 존재")
    void getWinningsByHowManyCorrect_4() {
        //Given
        int howManyCorrect = 4;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertEquals(Winnings.FOUR, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 5개, 존재")
    void getWinningsByHowManyCorrect_5() {
        //Given
        int howManyCorrect = 5;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertEquals(Winnings.FIVE, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 5개 + Bonus, 존재")
    void getWinningsByHowManyCorrect_5AndBonus() {
        //Given
        int howManyCorrect = 5;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, true);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertEquals(Winnings.FIVE_AND_BONUS, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 6개, 존재")
    void getWinningsByHowManyCorrect_6() {
        //Given
        int howManyCorrect = 6;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        Optional<Winnings> result = Winnings.getWinningsByHowManyCorrect(correctSpec);

        //Then
        assertEquals(Winnings.SIX, result.get());
    }
}