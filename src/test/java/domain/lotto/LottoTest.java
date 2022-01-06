package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @Test
    @DisplayName("로또 문자열에 중복이 있으면 로또 생성에 실패한다")
    void failToCreateLottoWithDuplicatedSequence() {
        //given
        List<Integer> lottoInputSequence = List.of(1, 1, 2, 3, 4, 5);

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoInputSequence))
                .withMessage("[에러] 로또 번호는 중복되는 숫자가 없어야 합니다.");
    }

    @Test
    @DisplayName("로또 문자열이 6자리가 아니면 로또 생성에 실패한다")
    void failToCreateLottoWithInvalidInputSize() {
        //given
        List<Integer> lottoInputSequence = List.of(1, 2, 3, 4, 5);

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoInputSequence))
                .withMessage("[에러] 로또 번호는 반드시 6개를 입력해야 합니다.");
    }
}