package lotto.domain.lottocomponent;

public class LottoPrice {

    public static final int LOTTO_MIN_PRICE = 1000;

    private final int price;

    public LottoPrice(int price) {
        validateLottoPrice(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validateLottoPrice(int price) {
        if (price < LOTTO_MIN_PRICE) {
            throw new IllegalArgumentException("로또 가격은 최소 " + LOTTO_MIN_PRICE + "를 입력해야합니다.");
        }
    }
}
