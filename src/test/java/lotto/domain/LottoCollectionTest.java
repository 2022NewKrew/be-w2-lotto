package lotto.domain;

import lotto.domain.LottoCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoCollectionTest {

    private static final int CREATED_SIZE = 10;

    @Test
    @DisplayName("구매한 만큼의 로또가 생성 되는지")
    void test1() {
        LottoCollection lottoCollection = new LottoCollection(CREATED_SIZE);
        assertThat(lottoCollection.getLottoCollection().size()).isEqualTo(CREATED_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("구입하는 값이 자연수가 아니라면 에러가 발생하는지")
    void test2(int count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoCollection(count));
    }
}