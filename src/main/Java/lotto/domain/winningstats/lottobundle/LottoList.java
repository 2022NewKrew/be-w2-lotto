package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import lotto.exception.IllegalManualLottoInputException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoList {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoList(long count) {
        List<Lotto> lottoListTemp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoListTemp.add(lotto);
        }
        lottoList = Collections.unmodifiableList(lottoListTemp);
    }

    public LottoList(String manualLottoNumbers) throws IllegalManualLottoInputException {
        List<Lotto> lottoListTemp = new ArrayList<>();
        for (String manualLottoNumber : manualLottoNumbers.split(LINE_SEPARATOR)) {
            Lotto lotto = new Lotto(manualLottoNumber);
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

    public LottoList concat(LottoList other) {
        List<Lotto> allLottoList = Stream.concat(this.lottoList.stream(), other.lottoList.stream()).collect(Collectors.toList());
        return new LottoList(allLottoList);
    }
}
