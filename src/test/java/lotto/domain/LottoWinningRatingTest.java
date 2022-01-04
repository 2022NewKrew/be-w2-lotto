package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningRatingTest {

    @DisplayName("getMatchingCount 테스트 - FIRST 인경우 6을 반환")
    @Test
    void getMatchCount_FIRST_6() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIRST;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(6, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - SECOND 인경우 5를 반환")
    @Test
    void getMatchCount_SECOND_5() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.SECOND;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(5, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - THIRD 인경우 5를 반환")
    @Test
    void getMatchCount_THIRD_5() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.THIRD;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(5, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - FOURTH 인경우 4을 반환")
    @Test
    void getMatchCount_FOURTH_4() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FOURTH;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(4, matchCount);

    }

    @DisplayName("getMatchingCount 테스트 - FIFTH 인경우 3을 반환")
    @Test
    void getMatchCount_FIFTH_3() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIFTH;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(3, matchCount);

    }

    @DisplayName("getMatchingCount 테스트 - NOTHING 인경우 0을 반환")
    @Test
    void getMatchCount_NOTHING_0() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.NOTHING;

        // When
        long matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(0, matchCount);
    }

    @DisplayName("getWinningMoney 테스트 - FIRST인 경우 2,000,000,000을 반환")
    @Test
    void getWinningMoney_FIRST_2000000000() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIRST;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(2_000_000_000, winningMoney);
    }

    @DisplayName("getWinningMoney 테스트 - SECOND인 경우 30,000,000을 반환")
    @Test
    void getWinningMoney_SECOND_30000000() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.SECOND;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(30_000_000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - THIRD인 경우 1,500,000을 반환")
    @Test
    void getWinningMoney_THIRD_1500000() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.THIRD;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(1_500_000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - FOURTH인 경우 50,000을 반환")
    @Test
    void getWinningMoney_FOURTH_50000() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FOURTH;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(50_000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - FIFTH인 경우 5,000을 반환")
    @Test
    void getWinningMoney_FIFTH_5000() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIFTH;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(5_000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - Nothing인 경우 0일 반환")
    @Test
    void getWinningMoney_NOTHING_0() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.NOTHING;

        // When
        long winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(0, winningMoney);

    }

    @DisplayName("getWinningRating 테스트 - matchCount가 6이고, hasBonusBall이 false 경우 FIRST를 반환")
    @Test
    void getWinningRating_MachCount6AndHasBonusBallIsFalse_FIRST() {
        // Given
        int matchCount = 6;
        boolean hasBonusBall = false;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.FIRST, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 5이고, hasBonusBall이 true 경우 SECOND를 반환")
    @Test
    void getWinningRating_MachCount5AndHasBonusBallIsTrue_SECOND() {
        // Given
        int matchCount = 5;
        boolean hasBonusBall = true;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.SECOND, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 5이고, hasBonusBall이 false 경우 THIRD를 반환")
    @Test
    void getWinningRating_MachCount5AndHasBonusBallIsFalse_THIRD() {
        // Given
        int matchCount = 5;
        boolean hasBonusBall = false;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.THIRD, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 4인 경우 FOURTH를 반환")
    @Test
    void getWinningRating_MachCount4_FOURTH() {
        // Given
        int matchCount = 4;
        boolean hasBonusBall = false;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.FOURTH, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 3인 경우 FIFTH를 반환")
    @Test
    void getWinningRating_MachCount3_FIFTH() {
        // Given
        int matchCount = 3;
        boolean hasBonusBall = false;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.FIFTH, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 2이하인 경우 NOTHING을 반환")
    @Test
    void getWinningRating_MachCountUnder2_NOTHING() {
        // Given
        int matchCount = 2;
        boolean hasBonusBall = false;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount, hasBonusBall);

        // Then
        Assertions.assertEquals(LottoWinningRating.NOTHING, result);
    }

}
