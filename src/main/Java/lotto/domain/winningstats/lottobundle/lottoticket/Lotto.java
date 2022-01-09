package lotto.domain.winningstats.lottobundle.lottoticket;

import lotto.domain.winningstats.lottobundle.LastWeekNumberBundle;
import lotto.exception.IllegalManualLottoInputException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SEPARATER = ",";
    private final List<Integer> lottoTicket;

    public Lotto() {
        lottoTicket = Collections.unmodifiableList(AllLottoNumberList.createAutoLottoTicket());
    }

    public Lotto(String lottoNumbers){
        final int LOTTO_TICKET_SIZE = 6;
        lottoTicket = Arrays.stream(lottoNumbers.split(SEPARATER)).map(Integer::parseInt).collect(Collectors.toList());
        if(lottoTicket.size()!=LOTTO_TICKET_SIZE){
            throw new IllegalManualLottoInputException("로또 번호의 숫자의 수가 "+LOTTO_TICKET_SIZE+"개가 아닙니다.");
        }
        if(lottoTicket.stream().distinct().count() != lottoTicket.size()){
            throw new IllegalManualLottoInputException("입력한 로또 번호에 중복된 숫자가 존재합니다.");
        }
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
