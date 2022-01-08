package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoPurchaseTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "30000:30"}, delimiter = ':')
    @DisplayName("구입 금액이 1000원인지")
    void test1(int money, int countOfPurchaseLotto) {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(money);
        assertThat(lottoPurchaseInfo.getCountOfPurchaseLotto()).isEqualTo(countOfPurchaseLotto);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1001:1", "29999:29"}, delimiter = ':')
    @DisplayName("제시한 금액의 최대치로 구매하는지")
    void test2(int money, int countOfPurchaseLotto) {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(money);
        assertThat(lottoPurchaseInfo.getCountOfPurchaseLotto()).isEqualTo(countOfPurchaseLotto);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    @DisplayName("구입 금액(1000원)이 부족하면 에러가 발생하는지")
    void test1Exception(int money) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPurchaseInfo(money));
    }


}