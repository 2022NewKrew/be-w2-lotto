package model.lottoResult;

import model.lotto.DefinedLottoGenerator;
import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utility.RandomSeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResult 테스트")
class LottoResultTest {

    @BeforeEach
    void setRandomSeed() {
        RandomSeed.setSeed(0);
    }

    @DisplayName("로또를 살 금액과 당첨 번호를 가지고 결과를 계산했을 때 기대한 총 수익과 생성된 총 수익이 같다.")
    @ParameterizedTest
    @MethodSource("getResultArguments")
    void getResult(Lotto winningLotto, LottoNumber bonusNumber, Map<Integer, Integer> expectedEarn) {
        //Give
        List<Lotto> lottos = getTestLottos();
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        //Then
        assertThat(lottoResult.getResult())
                .isEqualTo(expectedEarn);
    }

    @DisplayName("로또를 살 금액과 당첨 번호를 가지고 결과를 계산했을 때 기대한 수익률과 생성된 수익률이 같다..")
    @ParameterizedTest
    @MethodSource("getRevenuePercents")
    void testRevenuePercent(Lotto winningLotto, LottoNumber bonusNumber, int expectedRevenuePercent) {
        //Give
        List<Lotto> lottos = getTestLottos();
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        //Then
        assertThat(lottoResult.getRevenuePercent())
                .isEqualTo(expectedRevenuePercent);
    }

    static Stream<Arguments> getResultArguments() {
        return Stream.of(
                Arguments.of(
                        new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        LottoNumber.valueOf(7),
                        Map.of(
                                LottoRank.FAIL, 3,
                                LottoRank.FIFTH_PRIZE, 1,
                                LottoRank.FORTH_PRIZE, 1,
                                LottoRank.THIRD_PRIZE, 1,
                                LottoRank.SECOND_PRIZE, 1,
                                LottoRank.FIRST_PRIZE, 1
                        )
                ),
                Arguments.of(
                        new Lotto(DefinedLottoGenerator.generate(Arrays.asList(11, 12, 13, 14, 15, 16))),
                        LottoNumber.valueOf(7),
                        Map.of(
                                LottoRank.FAIL, 4,
                                LottoRank.FIFTH_PRIZE, 1,
                                LottoRank.FORTH_PRIZE, 1,
                                LottoRank.THIRD_PRIZE, 1,
                                LottoRank.SECOND_PRIZE, 0,
                                LottoRank.FIRST_PRIZE, 1
                        )
                )
        );
    }

    static Stream<Arguments> getRevenuePercents() {
        return Stream.of(
                Arguments.of(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6))), LottoNumber.valueOf(7), 25394437),
                Arguments.of(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(11, 12, 13, 14, 15, 16))), LottoNumber.valueOf(7), 25019437)
        );
    }

    List<Lotto> getTestLottos() {
        List<Lotto> results = new ArrayList<>();

        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(11, 12, 13, 14, 15, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 12, 13, 14, 15, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 13, 14, 15, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 14, 15, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 15, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 16))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 7))));
        results.add(new Lotto(DefinedLottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6))));

        return results;
    }
}
