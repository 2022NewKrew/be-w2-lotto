import generator.LottoSequenceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGeneratorTest {
    @DisplayName("로또 생성 사이즈 테스트")
    @Test
    void 로또_생성_사이즈_테스트() {
        // when
        List<Integer> lottoSequence = LottoSequenceGenerator.generate();

        // then
        Assertions.assertEquals(6, lottoSequence.size());
    }

    @DisplayName("로또 생성 범위 테스트")
    @RepeatedTest(10)
    void 로또_생성_범위_테스트() {
        // when
        List<Integer> lottoSequence = LottoSequenceGenerator.generate();

        // then
        Assertions.assertTrue(lottoSequence
                .stream()
                .noneMatch(lottoNumber -> lottoNumber < 1 || lottoNumber > 45));
    }

    @DisplayName("로또 생성 중복 테스트")
    @RepeatedTest(10)
    void 로또_생성_중복_테스트() {
        // when
        List<Integer> lottoSequence = LottoSequenceGenerator.generate();

        // then
        Assertions.assertEquals(6,
                lottoSequence.stream().distinct().count());
    }
}
