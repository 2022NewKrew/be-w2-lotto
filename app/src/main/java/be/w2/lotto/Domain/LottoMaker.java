package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    LottoNumbers lottoNumbers;

    public LottoMaker(){
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=45; i++)
            numbers.add(i);
        lottoNumbers = LottoNumbers.getInstanceByIntList(numbers);
    }
    
    public LottoTicket makeLottoTicket(){
        return new LottoTicket(lottoNumbers.getRandomTicketNumbers());
    }

}
