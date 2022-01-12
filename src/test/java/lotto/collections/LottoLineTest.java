package lotto.collections;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoLineTest {
    LottoLine l1 = new LottoLine();
    LottoLine l2 = new LottoLine();

    @Test
    @DisplayName("로또 번호 추가시 동일한 지 확인 테스트")
    void addNumberEqualTest() {

        l1.addNumber(new LottoNumber(1));
        l1.addNumber(new LottoNumber(2));
        l1.addNumber(new LottoNumber(3));

        l2.addNumber(new LottoNumber(1));
        l2.addNumber(new LottoNumber(2));
        l2.addNumber(new LottoNumber(3));

        assertThat(l1).isEqualTo(l2);
    }

    @Test
    @DisplayName("로또 번호 추가시 동일한 지 확인 테스트")
    void addNumberEqualTest2() {

        l1.addNumber(new LottoNumber(3));
        l1.addNumber(new LottoNumber(2));
        l1.addNumber(new LottoNumber(1));

        l2.addNumber(new LottoNumber(1));
        l2.addNumber(new LottoNumber(2));
        l2.addNumber(new LottoNumber(3));

        assertThat(l1).isEqualTo(l2);
    }

    @Test
    @DisplayName("로또 번호 동일하지 않은 경우 확인 테스트")
    void addNumberNotEqualTest1() {

        l1.addNumber(new LottoNumber(1));
        l1.addNumber(new LottoNumber(2));

        l2.addNumber(new LottoNumber(1));
        l2.addNumber(new LottoNumber(2));
        l2.addNumber(new LottoNumber(3));

        assertThat(l1).isNotEqualTo(l2);
    }

    @Test
    @DisplayName("로또 번호 동일하지 않은 경우 확인 테스트")
    void addNumberNotEqualTest2() {
        l1.addNumber(new LottoNumber(1));
        l1.addNumber(new LottoNumber(2));
        l1.addNumber(new LottoNumber(6));

        l2.addNumber(new LottoNumber(1));
        l2.addNumber(new LottoNumber(2));
        l2.addNumber(new LottoNumber(3));

        assertThat(l1).isNotEqualTo(l2);
    }




}
