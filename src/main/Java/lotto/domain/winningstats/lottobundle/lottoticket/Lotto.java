package lotto.domain.winningstats.lottobundle.lottoticket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final String SEPARATER = ",";
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_IN_LOTTO_TICKET = 6;
    private static final List<Integer> allLottoNumberList = IntStream.range(START_NUMBER, END_NUMBER + 1).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumberList;

    public Lotto() {
        Collections.shuffle(allLottoNumberList);
        List<Integer> lottoNumberListUnsorted = new ArrayList<>(allLottoNumberList).subList(0, COUNT_IN_LOTTO_TICKET);
        Collections.sort(lottoNumberListUnsorted);
        lottoNumberList = Collections.unmodifiableList(lottoNumberListUnsorted);
    }

    public Lotto(String lottoNumbers){
        lottoNumberList = Arrays.stream(lottoNumbers.split(SEPARATER)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }

    public String printLotto() {
        return String.valueOf(lottoNumberList);
    }
}
