package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void testSecondDescriptionIsValid() {
        LottoRank second = LottoRank.SECOND;
        String actualDescription = "5개 일치, 보너스 볼 일치 (30000000원)";
        assertEquals(second.getDescription(), actualDescription);
    }

    @Test
    void testRankOf5MatchesAndBonusTrueIsSecond() {
        assertEquals(LottoRank.valueOf(5, true), LottoRank.SECOND);
    }

    @Test
    void testRankOf5MatchesAndBonusFalseIsThird() {
        assertEquals(LottoRank.valueOf(5, false), LottoRank.THIRD);
    }
}