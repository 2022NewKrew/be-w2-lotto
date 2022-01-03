package domain;

public class LottoGameInfo {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoQuantity;

    public LottoGameInfo(int inputMoney) {
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
    }

    public int getNumOfPurchasedQuantity() {
        return lottoQuantity;
    }
}
