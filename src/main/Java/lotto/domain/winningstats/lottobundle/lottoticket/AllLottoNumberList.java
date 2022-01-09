package lotto.domain.winningstats.lottobundle.lottoticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllLottoNumberList {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_IN_LOTTO_TICKET = 6;
    private static final List<Integer> allLottoNumberList = IntStream.range(START_NUMBER, END_NUMBER + 1).boxed().collect(Collectors.toList());

    public static List<Integer> createAutoLottoTicket() {
        AllLottoNumberList.shuffle();
        List<Integer> lottoTicket = sublist();
        Collections.sort(lottoTicket);
        return lottoTicket;
    }

    private static List<Integer> sublist() {
        return new ArrayList<>(allLottoNumberList).subList(0, COUNT_IN_LOTTO_TICKET);
    }

    private static void shuffle() {
        Collections.shuffle(allLottoNumberList);
    }
}
