package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningRatingTest {

    @DisplayName("getMatchingCount 테스트 - FIRST 인경우")
    @Test
    void getMatchCountWithFirst() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIRST;

        // When
        Integer matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(6, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - SECOND 인경우")
    @Test
    void getMatchCountWithSecond() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.SECOND;

        // When
        Integer matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(5, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - THIRD 인경우")
    @Test
    void getMatchCountWithThird() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.THIRD;

        // When
        Integer matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(4, matchCount);
    }

    @DisplayName("getMatchingCount 테스트 - FOURTH 인경우")
    @Test
    void getMatchCountWithFourth() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FOURTH;

        // When
        Integer matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(3, matchCount);

    }

    @DisplayName("getMatchingCount 테스트 - NOTHING 인경우")
    @Test
    void getMatchCountWithNothing() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.NOTHING;

        // When
        Integer matchCount = lottoWinningRating.getMatchCount();

        // Then
        Assertions.assertEquals(0, matchCount);
    }

    @DisplayName("getWinningMoney 테스트 - FIRST인 경우")
    @Test
    void getWinningMoneyWithFirst() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FIRST;

        // When
        Integer winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(2000000000, winningMoney);
    }

    @DisplayName("getWinningMoney 테스트 - SECOND인 경우")
    @Test
    void getWinningMoneyWithSecond() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.SECOND;

        // When
        Integer winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(1500000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - THIRD인 경우")
    @Test
    void getWinningMoneyWithThird() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.THIRD;

        // When
        Integer winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(50000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - FOURTH인 경우")
    @Test
    void getWinningMoneyWithFourth() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.FOURTH;

        // When
        Integer winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(5000, winningMoney);

    }

    @DisplayName("getWinningMoney 테스트 - Nothing인 경우")
    @Test
    void getWinningMoneyWithNothing() {
        // Given
        LottoWinningRating lottoWinningRating = LottoWinningRating.NOTHING;

        // When
        Integer winningMoney = lottoWinningRating.getWinningMoney();

        // Then
        Assertions.assertEquals(0, winningMoney);

    }

    @DisplayName("getWinningRating 테스트 - matchCount가 6인 경우")
    @Test
    void getWinningRatingWithMachCount6() {
        // Given
        int matchCount = 6;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount);

        // Then
        Assertions.assertEquals(LottoWinningRating.FIRST, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 5인 경우")
    @Test
    void getWinningRatingWithMachCount5() {
        // Given
        int matchCount = 5;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount);

        // Then
        Assertions.assertEquals(LottoWinningRating.SECOND, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 4인 경우")
    @Test
    void getWinningRatingWithMachCount4() {
        // Given
        int matchCount = 4;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount);

        // Then
        Assertions.assertEquals(LottoWinningRating.THIRD, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 3인 경우")
    @Test
    void getWinningRatingWithMachCount3() {
        // Given
        int matchCount = 3;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount);

        // Then
        Assertions.assertEquals(LottoWinningRating.FOURTH, result);
    }

    @DisplayName("getWinningRating 테스트 - matchCount가 2이하인 경우")
    @Test
    void getWinningRatingWithMachCountUnder3() {
        // Given
        int matchCount = 2;

        // When
        LottoWinningRating result = LottoWinningRating.getWinningRating(matchCount);

        // Then
        Assertions.assertEquals(LottoWinningRating.NOTHING, result);
    }
}