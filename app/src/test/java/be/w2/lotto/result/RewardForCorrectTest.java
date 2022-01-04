package be.w2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RewardForCorrectTest {

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 0개, 존재하지 않음")
    void getRewordForCorrectByHowManyCorrect_0() {
        //Given
        int howManyCorrect = 0;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 1개, 존재하지 않음")
    void getRewordForCorrectByHowManyCorrect_1() {
        //Given
        int howManyCorrect = 1;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 2개, 존재하지 않음")
    void getRewordForCorrectByHowManyCorrect_2() {
        //Given
        int howManyCorrect = 2;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 3개, 존재")
    void getRewordForCorrectByHowManyCorrect_3() {
        //Given
        int howManyCorrect = 3;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertEquals(RewardForCorrect.THREE, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 4개, 존재")
    void getRewordForCorrectByHowManyCorrect_4() {
        //Given
        int howManyCorrect = 4;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertEquals(RewardForCorrect.FOUR, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 5개, 존재")
    void getRewordForCorrectByHowManyCorrect_5() {
        //Given
        int howManyCorrect = 5;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertEquals(RewardForCorrect.FIVE, result.get());
    }

    @Test
    @DisplayName("맞은 개수에 해당하는 객체 반환 -> 6개, 존재")
    void getRewordForCorrectByHowManyCorrect_6() {
        //Given
        int howManyCorrect = 6;

        //When
        Optional<RewardForCorrect> result = RewardForCorrect.getRewordForCorrectByHowManyCorrect(howManyCorrect);

        //Then
        assertEquals(RewardForCorrect.SIX, result.get());
    }
}