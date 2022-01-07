package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoList {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    final List<Lotto> lottoList;

    public LottoList(long count) {
        List<Lotto> lottoListTemp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoListTemp.add(lotto);
        }
        lottoList = Collections.unmodifiableList(lottoListTemp);
    }

    public String printLottoList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto.printLotto());
            stringBuilder.append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public int size() {
        return lottoList.size();
    }

    public Iterator<Lotto> getIterator() {
        return lottoList.iterator();
    }
}
