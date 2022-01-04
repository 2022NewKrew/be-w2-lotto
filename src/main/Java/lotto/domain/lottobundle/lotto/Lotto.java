package lotto.domain.lottobundle.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_IN_LOTTO_TICKET = 6;
    private static List<Integer> allLottoNumberList;
    private final List<Integer> lottoNumberList;

    public Lotto() {
        allLottoNumberList = IntStream.range(START_NUMBER,END_NUMBER+1).boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumberList);
        List<Integer> lottoNumberListUnsorted = new ArrayList<>(allLottoNumberList).subList(0,COUNT_IN_LOTTO_TICKET);
        Collections.sort(lottoNumberListUnsorted);
        lottoNumberList = Collections.unmodifiableList(lottoNumberListUnsorted);
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoNumberList);
        return stringBuilder.toString();
    }
}
