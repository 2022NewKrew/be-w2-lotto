package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @DisplayName("1~45 범위의 로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void create(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(number));
    }

    @DisplayName("범위를 벗어나는 로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createInvalidLottoNumber(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(number))
                .withMessage("1~45 사이의 값을 입력해야합니다.");
    }
}
