package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private static final String SEPERATOR = "\n";
    private final int LOTTO_PRICE = 1000;
    private final int totalMoney;
    private final List<Lotto> lottoList;

    public LottoBundle(int totalMoney) {
        this.totalMoney = totalMoney;
        this.lottoList = new ArrayList<>();
        int count = getCount();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        Collections.unmodifiableList(lottoList);
    }

    public int getCount(){
        return totalMoney/LOTTO_PRICE;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
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
