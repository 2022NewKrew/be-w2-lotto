package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER   = 45;
    private LottoNumbers lottoNumbers;

    public LottoMaker() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= END_NUMBER; i++)
            numbers.add(i);
        lottoNumbers = LottoNumbers.getInstanceByIntList(numbers);
    }

    public LottoTicket makeLottoTicket() {
        return new LottoTicket(lottoNumbers.getRandomTicketNumbers());
    }

}
