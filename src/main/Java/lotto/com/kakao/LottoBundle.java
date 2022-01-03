package lotto.com.kakao;

public class LottoBundle {
    private final int LOTTO_PRICE = 1000;
    private final int totalMoney;

    public LottoBundle(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getCount(){
        return totalMoney/LOTTO_PRICE;
    }
}
