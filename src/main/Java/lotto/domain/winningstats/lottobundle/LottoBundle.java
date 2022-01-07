package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private static final String SEPARATOR = "\n";
    private final long lottoPurchaseMoney;
    private final List<Lotto> lottoList;

    public LottoBundle(long lottoPurchaseMoney) {
        List<Lotto> lottoListTemp;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        lottoListTemp = new ArrayList<>();
        long count = getCount();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoListTemp.add(lotto);
        }
        this.lottoList = Collections.unmodifiableList(lottoListTemp);
    }

    public long getCount() {
        final long LOTTO_PRICE = 1000;
        return lottoPurchaseMoney / LOTTO_PRICE;
    }

    public long getLottoPurchaseMoney(){
        return lottoPurchaseMoney;
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
