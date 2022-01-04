package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("범위를 벗어나는 돈 생성 테스트")
    @Test
    public void create() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1000))
                .withMessage("0원 이상의 금액을 입력해주세요.");
    }
}