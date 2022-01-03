package lotto.com.kakao;

import java.util.List;

public class LottoBundle {
    private final int LOTTO_PRICE = 1000;
    private final int totalMoney;
    private List<Lotto> LottoList;

    public LottoBundle(int totalMoney) {
        this.totalMoney = totalMoney;
        int count = getCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            // LottoList.add(lotto);
        }
    }

    public int getCount(){
        return totalMoney/LOTTO_PRICE;
    }

}
