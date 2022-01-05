import back.domain.Lotto;
import back.domain.Prize;
import back.domain.WinningLotto;
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
    void 로또_결과_반환_테스트(Lotto lotto, WinningLotto answer, Prize expected){
        Prize prize = lotto.getResult(answer);
        Assertions.assertEquals(expected, prize);
    }

    private static Stream<Arguments> 로또_결과_반환_테스트(){
        return Stream.of(
                // 맞은 개수 1, 보너스 볼 true
                Arguments.arguments(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(List.of(1, 7, 8, 9, 10, 11, 12), 6),
                        null),
                // 맞은 개수 2, 보너스 볼 true
                Arguments.arguments(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(List.of(1, 2, 8, 9, 10, 11, 12), 6),
                        null),
                // 맞은 개수 4, 보너스 볼 true
                Arguments.arguments(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(List.of(1, 2, 3, 4, 14, 20), 5),
                        Prize.THIRD),
                // 맞은 개수 5, 보너스 볼 false
                Arguments.arguments(
                        new Lotto(List.of(6, 8, 12, 24, 27, 39)),
                        new WinningLotto(List.of(6, 8, 24, 27, 39, 41), 2),
                        Prize.SECOND),
                // 맞은 개수 5, 보너스 볼 true
                Arguments.arguments(
                        new Lotto(List.of(6, 8, 12, 24, 27, 39)),
                        new WinningLotto(List.of(6, 8, 24, 27, 41, 39), 24),
                        Prize.SECOND_BONUS));
    }
}
