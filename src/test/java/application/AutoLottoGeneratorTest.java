package application;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoGeneratorTest {
    private static final int MIM_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final LottoGenerator lottoGenerator = new AutoLottoGenerator();

    @DisplayName("생성한 로또가 전부 다른 값인지 검증")
    @RepeatedTest(50)
    void 로또_번호_중복검사() {
        Lotto lotto = lottoGenerator.getLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers.stream().distinct().count())
                .isEqualTo(lottoNumbers.size());
    }

    @DisplayName("생성된 로또의 값이 1~45의 자연수인지 검증")
    @RepeatedTest(50)
    void 로또_번호_정확성검사() {
        Lotto lotto = lottoGenerator.getLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers.stream().anyMatch(e -> !(e >= MIM_LOTTO_NUMBER && e < MAX_LOTTO_NUMBER)))
                .isFalse();
    }
}