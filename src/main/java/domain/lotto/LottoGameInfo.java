package domain.lotto;

public class LottoGameInfo {

    private static final int LOTTO_PRICE = 1000;

    private final int inputMoney;
    private final int lottoQuantity;

    public LottoGameInfo(int inputMoney) {
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
    }

    private void validateInputMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("[에러] 구입 금액은 반드시 %s원 이상이어야 합니다.", LOTTO_PRICE));
        }
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public int getPurchasedQuantity() {
        return lottoQuantity;
    }
}
