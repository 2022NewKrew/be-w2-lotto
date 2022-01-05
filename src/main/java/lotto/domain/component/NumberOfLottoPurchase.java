package lotto.domain.component;

import static lotto.domain.component.LottoPrice.LOTTO_MIN_PRICE;

public class NumberOfLottoPurchase {

    public static final int LOTTO_PURCHASE_MIN_NUMBER = 0;

    private final int number;

    public NumberOfLottoPurchase(int number, int price) {
        validateNumberOfLotto(number, price);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberOfLotto(int number, int price) {
        if (number < LOTTO_PURCHASE_MIN_NUMBER) {
            throw new IllegalArgumentException("구매할 로또의 갯수가 이상합니다.");
        }

        if (price < number * LOTTO_MIN_PRICE) {
            throw new IllegalArgumentException("현재 금액으로는" + number + "개를 구매할 수 없습니다.");
        }
    }

}
