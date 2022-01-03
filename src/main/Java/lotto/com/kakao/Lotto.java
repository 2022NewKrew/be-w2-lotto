package lotto.com.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_IN_LOTTO_TICKET = 6;
    private static List<Integer> allLottoNumberList = IntStream.range(START_NUMBER,END_NUMBER+1).boxed().collect(Collectors.toList());
    private static List<Integer> lottoNumberList;

    public Lotto() {
        this.lottoNumberList = IntStream.range(START_NUMBER,COUNT_IN_LOTTO_TICKET+1).boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumberList);
        lottoNumberList = new ArrayList<>(allLottoNumberList);
        lottoNumberList = lottoNumberList.subList(0,COUNT_IN_LOTTO_TICKET);
    }
}
