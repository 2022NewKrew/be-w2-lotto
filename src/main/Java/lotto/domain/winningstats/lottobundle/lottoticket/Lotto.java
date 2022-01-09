package lotto.domain.winningstats.lottobundle.lottoticket;

import lotto.domain.winningstats.lottobundle.LastWeekNumberBundle;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SEPARATER = ",";
    private final List<Integer> lottoTicket;

    public Lotto() {
        lottoTicket = Collections.unmodifiableList(AllLottoNumberList.createAutoLottoTicket());
    }

    public Lotto(String lottoNumbers){
        lottoTicket = Arrays.stream(lottoNumbers.split(SEPARATER)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public String printLotto() {
        return String.valueOf(lottoTicket);
    }

    public boolean contains(int lottoNumber) {
        return lottoTicket.contains(lottoNumber);
    }

    public int getCorrectCount(LastWeekNumberBundle lastWeekNumber) {
        int correctCount = 0;
        for(int lottoNumber : lottoTicket)
            correctCount += lastWeekNumber.addOneIfContains(lottoNumber);
        return correctCount;
    }
}
