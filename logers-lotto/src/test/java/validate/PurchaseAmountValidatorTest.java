package validate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = new PurchaseAmountValidator();
    }

    @ParameterizedTest
    @DisplayName("가격이 양수가 아닐 때 검증 실패")
    @ValueSource(ints = {-500000, -10000, -1000, 0})
    public void testFailedWhenPriceNotPositive(int price){
        assertThatThrownBy(() -> validator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @ParameterizedTest
    @DisplayName("가격이 로또 가격의 단위로 나눠지지 않을 때 검증 실패")
    @ValueSource(ints = {5, 10, 100, 5500, 10100, 1000010})
    public void testFailedWhenPriceNotDividedByLottoPrice(int price){
        assertThatThrownBy(()-> validator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위");
    }
}