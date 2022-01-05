package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private static final String SEPARATOR = "\n";
    private final int totalMoney;
    private final List<Lotto> lottoList;

    public LottoBundle(int totalMoney) {
        List<Lotto> lottoListTemp;
        this.totalMoney = totalMoney;
        lottoListTemp = new ArrayList<>();
        int count = getCount();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoListTemp.add(lotto);
        }
        this.lottoList = Collections.unmodifiableList(lottoListTemp);
    }

    public int getCount() {
        final int LOTTO_PRICE = 1000;
        return totalMoney / LOTTO_PRICE;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public String printLottoBundle() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto.printLotto());
            stringBuilder.append(SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
