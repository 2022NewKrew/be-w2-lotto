package lotto.collections;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @BeforeEach
    public void setup(){


        LottoNumber n3 = new LottoNumber(15);
    }

    @Test
    @DisplayName("동일한 로또 넘버 확인")
    void testEquals() {
        LottoNumber n1 = new LottoNumber(10);
        LottoNumber n2 = new LottoNumber(10);
        assertThat(n1).isEqualTo(n2);
    }

    @Test
    @DisplayName("서로 다른 로또 넘버 확인")
    void testNotEquals() {
        LottoNumber n1 = new LottoNumber(10);
        LottoNumber n2 = new LottoNumber(11);
        assertThat(n1).isNotEqualTo(n2);
    }

    @Test
    @DisplayName("로또 숫자 범위보다 작은 경우 확인")
    void testLowerBound() {
        assertThatThrownBy(()-> new LottoNumber(0))
                .isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("로또 숫자 범위보다 큰 경우 확인")
    void testUpperBound() {
        assertThatThrownBy(()-> new LottoNumber(58))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자 범위 안인 경우 exception 안 날리고 정상 작동하는지 확인")
    void testGeneral() {
        assertThatThrownBy(()-> new LottoNumber(40))
                .isNotInstanceOf(Exception.class);
    }
}
