package lotto.collections;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoLineTest {
    Set<LottoNumber> l1 = new HashSet<>();
    Set<LottoNumber> l2 = new HashSet<>();


    @Test
    @DisplayName("로또 번호 6개 이상 작성한 경우")
    void longLottoLineTest() {

        l1.add(new LottoNumber(1));
        l1.add(new LottoNumber(2));
        l1.add(new LottoNumber(3));
        l1.add(new LottoNumber(4));
        l1.add(new LottoNumber(5));
        l1.add(new LottoNumber(6));
        l1.add(new LottoNumber(7));

        assertThatThrownBy(()-> {LottoLine lottoLine = new LottoLine(l1);})
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 추가시 동일한 지 확인 테스트")
    void addNumberEqualTest2() {

        l1.add(new LottoNumber(3));
        l1.add(new LottoNumber(2));
        l1.add(new LottoNumber(1));
        l1.add(new LottoNumber(4));
        l1.add(new LottoNumber(5));
        l1.add(new LottoNumber(6));

        l2.add(new LottoNumber(1));
        l2.add(new LottoNumber(2));
        l2.add(new LottoNumber(3));
        l2.add(new LottoNumber(4));
        l2.add(new LottoNumber(5));
        l2.add(new LottoNumber(6));

        LottoLine lottoLine1 = new LottoLine(l1);
        LottoLine lottoLine2 = new LottoLine(l2);

        assertThat(lottoLine1).isEqualTo(lottoLine2);
    }

    @Test
    @DisplayName("로또 번호 동일하지 않은 경우 확인 테스트")
    void addNumberNotEqualTest1() {

        l1.add(new LottoNumber(1));
        l1.add(new LottoNumber(2));
        l1.add(new LottoNumber(3));
        l1.add(new LottoNumber(4));
        l1.add(new LottoNumber(5));
        l1.add(new LottoNumber(7));

        l2.add(new LottoNumber(1));
        l2.add(new LottoNumber(2));
        l2.add(new LottoNumber(3));
        l2.add(new LottoNumber(4));
        l2.add(new LottoNumber(5));
        l2.add(new LottoNumber(6));

        LottoLine lottoLine1 = new LottoLine(l1);
        LottoLine lottoLine2 = new LottoLine(l2);

        assertThat(lottoLine1).isNotEqualTo(lottoLine2);
    }

    @Test
    @DisplayName("로또 번호 동일하지 않은 경우 확인 테스트")
    void addNumberNotEqualTest2() {
        l1.add(new LottoNumber(1));
        l1.add(new LottoNumber(2));
        l1.add(new LottoNumber(6));
        l1.add(new LottoNumber(8));
        l1.add(new LottoNumber(33));
        l1.add(new LottoNumber(45));

        l2.add(new LottoNumber(1));
        l2.add(new LottoNumber(2));
        l2.add(new LottoNumber(3));
        l2.add(new LottoNumber(8));
        l2.add(new LottoNumber(33));
        l2.add(new LottoNumber(44));

        LottoLine lottoLine1 = new LottoLine(l1);
        LottoLine lottoLine2 = new LottoLine(l2);

        assertThat(lottoLine1).isNotEqualTo(lottoLine2);
    }




}
