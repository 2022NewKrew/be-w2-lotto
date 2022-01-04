package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoOrderTest {
    @ParameterizedTest
    @DisplayName("가격이 양수가 아닐 때 검증 실패")
    @ValueSource(ints = {-500000, -10000, -1000, 0})
    public void failedWhenPriceNotPositive(int price){
        assertThatThrownBy(() -> new LottoOrder(price, getRightNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @ParameterizedTest
    @DisplayName("가격이 로또 가격의 단위로 나눠지지 않을 때 검증 실패")
    @ValueSource(ints = {5, 10, 100, 5500, 10100, 1000010})
    public void failedWhenPriceNotDividedByLottoPrice(int price){
        assertThatThrownBy(()-> new LottoOrder(price, getRightNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위");
    }

    private static List<List<Integer>> getRightNumbers(){
        return List.of(List.of(1, 3, 5, 6, 33, 45));
    }
}