package lotto.com.kakao;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private static final String SEPERATOR = "\n";
    private final int LOTTO_PRICE = 1000;
    private final int totalMoney;
    private List<Lotto> lottoList;

    public LottoBundle(int totalMoney) {
        this.totalMoney = totalMoney;
        this.lottoList = new ArrayList<>();
        int count = getCount();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
    }

    public int getCount(){
        return totalMoney/LOTTO_PRICE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto);
            stringBuilder.append(SEPERATOR);
        }
        return stringBuilder.toString();
    }
}
