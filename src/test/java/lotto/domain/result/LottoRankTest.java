package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 랭크 테스트")
public class LottoRankTest {

    @ParameterizedTest(name="{index} 등 랭크 확인")
    @MethodSource("getMatchingNumbersAndBonusNumber")
    @DisplayName("일치 개수와 보너스 넘버로 제대로된 등수 가져오기")
    void getLottoRankByNumbersAndBonusNumber(MatchingInfo matchingInfo) {
        //given
        int matchingNumber = matchingInfo.getMatchingNumber();
        boolean bonusNumber = matchingInfo.isBonusNumber();
        LottoRank lottoRank = matchingInfo.getLottoRank();

        //when
        LottoRank lottoRankResult = LottoRank.lookup(matchingNumber, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(lottoRankResult);
    }

    private static Stream<MatchingInfo> getMatchingNumbersAndBonusNumber(){
        return Stream.of(
                new MatchingInfo(6, false, LottoRank.FIRST_PRIZE),
                new MatchingInfo(5, true, LottoRank.SECOND_PRIZE),
                new MatchingInfo(5, false, LottoRank.THIRD_PRIZE),
                new MatchingInfo(4, false, LottoRank.FOURTH_PRIZE),
                new MatchingInfo(3, false, LottoRank.FIFTH_PRIZE),
                new MatchingInfo(2, false, LottoRank.BLANK),
                new MatchingInfo(1, false, LottoRank.BLANK),
                new MatchingInfo(0, false, LottoRank.BLANK)
        );
    }

    static class MatchingInfo{
        private final int matchingNumber;
        private final boolean bonusNumber;
        private final LottoRank lottoRank;

        public MatchingInfo(int matchingNumber, boolean bonusNumber, LottoRank lottoRank) {
            this.matchingNumber = matchingNumber;
            this.bonusNumber = bonusNumber;
            this.lottoRank = lottoRank;
        }

        public int getMatchingNumber() {
            return matchingNumber;
        }

        public boolean isBonusNumber() {
            return bonusNumber;
        }

        public LottoRank getLottoRank() {
            return lottoRank;
        }
    }
}
