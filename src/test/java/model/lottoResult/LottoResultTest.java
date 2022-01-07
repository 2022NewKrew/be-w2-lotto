package model.lottoResult;

import model.lotto.Lotto;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utility.RandomSeed;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    void getResult(int numberOfLotto, Lotto winningLotto, LottoNumber bonusNumber, Map<Integer, Integer> expectedEarn) {
        //Give
        List<Lotto> lottos =
                IntStream
                        .range(0, numberOfLotto)
                        .mapToObj(notUse -> Lotto.getRandomLotto())
                        .collect(Collectors.toList());
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        //Then
        assertThat(lottoResult.getResult())
                .isEqualTo(expectedEarn);
    }

    @DisplayName("로또를 살 금액과 당첨 번호를 가지고 결과를 계산했을 때 기대한 수익률과 생성된 수익률이 같다..")
    @ParameterizedTest
    @MethodSource("getRevenuePercents")
    void getRevenuePercent(int numberOfLotto, Lotto winningLotto, LottoNumber bonusNumber, int expectedRevenuePercent) {
        //Give
        List<Lotto> lottos =
                IntStream
                        .range(0, numberOfLotto)
                        .mapToObj(notUse -> Lotto.getRandomLotto())
                        .collect(Collectors.toList());
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        //Then
        assertThat(lottoResult.getRevenuePercent())
                .isEqualTo(expectedRevenuePercent);
    }

    static Stream<Arguments> getResultArguments() {
        return Stream.of(
                Arguments.of(
                        1000,
                        Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LottoNumber.valueOf(7),
                        Map.of(0, 979, 5000, 21)
                ),
                Arguments.of(
                        2000,
                        Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LottoNumber.valueOf(7),
                        Map.of(0, 1962, 5000, 36, 50000, 2)
                ),
                Arguments.of(
                        3000,
                        Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LottoNumber.valueOf(7),
                        Map.of(0, 2944, 5000, 53, 50000, 3)
                ),
                Arguments.of(
                        1000,
                        Lotto.getDefinedLotto(Arrays.asList(12, 16, 19, 22, 32, 45)),
                        LottoNumber.valueOf(1),
                        Map.of(0, 977, 5000, 21, 50000, 1, 1500000, 1)
                ),
                Arguments.of(
                        1000,
                        Lotto.getDefinedLotto(Arrays.asList(12, 16, 19, 22, 32, 45)),
                        LottoNumber.valueOf(36),
                        Map.of(0, 977, 5000, 21, 50000, 1, 30000000, 1)
                )
                ,
                Arguments.of(
                        1000,
                        Lotto.getDefinedLotto(Arrays.asList(12, 16, 19, 22, 32, 36)),
                        LottoNumber.valueOf(1),
                        Map.of(0, 975, 5000, 22, 50000, 2, 2000000000, 1)
                )
        );
    }

    static Stream<Arguments> getRevenuePercents() {
        return Stream.of(
                Arguments.of(1000, Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), 10),
                Arguments.of(2000, Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), 14),
                Arguments.of(3000, Lotto.getDefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), 13)
        );
    }
}
