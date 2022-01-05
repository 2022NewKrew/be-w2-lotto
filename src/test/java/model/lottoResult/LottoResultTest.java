package model.lottoResult;

import controller.SellLottoController;
import model.lotto.DefinedLotto;
import model.lotto.RandomLotto;
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
    void getResult(int money, DefinedLotto winningLotto, int expectedEarn) {
        //Give
        List<RandomLotto> lottos = SellLottoController.buyLottos(money);
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        //Then
        System.out.println(lottoResult.getResult().toString());
        assertThat(calculateTotalEarn(lottoResult.getResult())).isEqualTo(expectedEarn);
    }

    @DisplayName("로또를 살 금액과 당첨 번호를 가지고 결과를 계산했을 때 기대한 수익률과 생성된 수익률이 같다..")
    @ParameterizedTest
    @MethodSource("getRevenuePercents")
    void getRevenuePercent(int money, DefinedLotto winningLotto, int expectedRevenuePercent) {
        //Give
        List<RandomLotto> lottos = SellLottoController.buyLottos(money);
        //When
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        //Then
        System.out.println(lottoResult.getResult().toString());
        assertThat(lottoResult.getRevenuePercent()).isEqualTo(expectedRevenuePercent);
    }

    static Stream<Arguments> getResultArguments() {
        return Stream.of(
                Arguments.of(1000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 105000),
                Arguments.of(2000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 280000),
                Arguments.of(3000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 415000)
        );
    }

    static Stream<Arguments> getRevenuePercents() {
        return Stream.of(
                Arguments.of(1000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                Arguments.of(2000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 14),
                Arguments.of(3000000, new DefinedLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 13)
        );
    }

    private int calculateTotalEarn(Map<Integer, Integer> result) {
        return result
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }
}
