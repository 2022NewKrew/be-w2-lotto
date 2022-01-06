package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {
    LottoAutoGenerator lottoAutoGenerator;

    @BeforeEach
    void setUp() {
        lottoAutoGenerator = new LottoAutoGenerator();
    }

    @DisplayName("임의의 로또를 입력받은 숫자만큼 생성하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void getRandomLottos(int num) {
        List<Lotto> lottoList = lottoAutoGenerator.getRandomLottos(num);
        assertThat(lottoList.size()).isEqualTo(num);
    }
}