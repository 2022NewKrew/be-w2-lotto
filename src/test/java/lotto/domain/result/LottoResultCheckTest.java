package lotto.domain.result;

import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerLottoList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또 결과 체크 테스트")
class LottoResultCheckTest {

    public static LottoResultChecker lottoResultChecker;

    @BeforeAll
    static void beforeAll(){
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottoInfo winningLottoInfo = new WinningLottoInfo(winningLotto, bonusNumber);
        lottoResultChecker = new LottoResultChecker(winningLottoInfo);
    }

    @Test
    @DisplayName("플레이어의 모든 로또 결과 통계를 가져와야 한다.")
    void getLottoResults() {
        // given
        PlayerLottoList playerLottoList = new PlayerLottoList();
        playerLottoList.addPlayerLotto(new PlayerLotto());
        playerLottoList.addPlayerLotto(new PlayerLotto());

        // when
        List<LottoResult> lottoResults = lottoResultChecker.getLottoResults(playerLottoList);

        // then
        assertThat(lottoResults.size()).isEqualTo(6);
    }

    @ParameterizedTest(name="{index}등 결과 테스트")
    @MethodSource("getPlayerLottoNumbers")
    @DisplayName("1~5등 로또 결과를 가져올 수 있어야 한다.")
    void getLottoRankByPlayerLotto(LottoInfo lottoInfo) {
        //given
        PlayerLotto playerLotto = lottoInfo.getPlayerLotto();
        LottoRank lottoRank = lottoInfo.getLottoRank();

        //when
        LottoRank resultRank = lottoResultChecker.getOneLottoRank(playerLotto);

        //then
        assertThat(resultRank).isEqualTo(lottoRank);
    }

    private static Stream<LottoInfo> getPlayerLottoNumbers(){
        return Stream.of(
                new LottoInfo(new PlayerLotto((Arrays.asList(1, 2, 3, 4, 5, 6))), LottoRank.FIRST_PRIZE),
                new LottoInfo(new PlayerLotto((Arrays.asList(1, 2, 3, 4, 5, 7))), LottoRank.SECOND_PRIZE),
                new LottoInfo(new PlayerLotto((Arrays.asList(1, 2, 3, 4, 5, 8))), LottoRank.THIRD_PRIZE),
                new LottoInfo(new PlayerLotto((Arrays.asList(1, 2, 3, 4, 8, 9))), LottoRank.FOURTH_PRIZE),
                new LottoInfo(new PlayerLotto((Arrays.asList(1, 2, 3, 8, 9, 10))), LottoRank.FIFTH_PRIZE)
        );
    }

    static class LottoInfo{
        private final PlayerLotto playerLotto;
        private final LottoRank lottoRank;

        public LottoInfo(PlayerLotto playerLotto, LottoRank lottoRank) {
            this.playerLotto = playerLotto;
            this.lottoRank = lottoRank;
        }

        public PlayerLotto getPlayerLotto() {
            return playerLotto;
        }

        public LottoRank getLottoRank() {
            return lottoRank;
        }
    }
}