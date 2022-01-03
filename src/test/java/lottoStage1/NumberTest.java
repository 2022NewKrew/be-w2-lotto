package lottoStage1;

import lottoStage1.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("1 ~ 45 범위의 숫자를 생성")
    @RepeatedTest(20)
    void create() {
        Number number = Number.create();
        assertThat(number.getNumber()).isGreaterThan(0).isLessThan(46);
    }

}