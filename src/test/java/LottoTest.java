import domain.Lotto;
import domain.Prize;
import domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LottoTest {
    @DisplayName("로또 결과 테스트")
    @ParameterizedTest
    @MethodSource
    void 로또_결과_반환_테스트(Lotto lotto, WinningLotto answer, int expected){
        Prize prize = lotto.getResult(answer);

        Assertions.assertEquals(expected, prize.getCorrectAmount());
    }

    private static Stream<Arguments> 로또_결과_반환_테스트(){
        return Stream.of(
                Arguments.arguments(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(List.of(1, 7, 8, 9, 10, 11, 12)),
                        1),

                Arguments.arguments(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(List.of(10, 11, 12, 13, 14, 20)),
                        0),

                Arguments.arguments(
                        new Lotto(List.of(6, 8, 12, 24, 27, 39)),
                        new WinningLotto(List.of(5, 9, 26, 31, 35, 41)),
                        0),

                Arguments.arguments(
                        new Lotto(List.of(6, 8, 12, 24, 27, 39)),
                        new WinningLotto(List.of(13, 12, 6, 8, 35, 39)),
                        4));
    }
}
