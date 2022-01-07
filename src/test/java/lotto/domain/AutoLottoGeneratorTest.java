package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutoLottoGeneratorTest {

    LottoGenerator autoLottoGenerator;

    @DisplayName("임의의 로또를 입력받은 숫자만큼 생성하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getRandomLottos(int num) {
        autoLottoGenerator = new AutoLottoGenerator(num);
        List<Lotto> lottoList = autoLottoGenerator.generate();
        assertThat(lottoList.size()).isEqualTo(num);
    }
}