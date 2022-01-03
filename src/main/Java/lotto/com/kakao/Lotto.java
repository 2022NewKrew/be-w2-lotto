package lotto.com.kakao;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_IN_LOTTO_TICKET = 6;
    private static List<Integer> allLottoNumberList;
    private List<Integer> lottoNumberList;

    public Lotto() {
        allLottoNumberList = IntStream.range(START_NUMBER,COUNT_IN_LOTTO_TICKET+1).boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumberList);
        lottoNumberList = new ArrayList<>(allLottoNumberList);
        lottoNumberList = lottoNumberList.subList(0,COUNT_IN_LOTTO_TICKET);
        lottoNumberList = Collections.unmodifiableList(lottoNumberList);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoNumberList);
        return stringBuilder.toString();
    }
}
