package lotto.domain;

import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoPrice;
import lotto.domain.component.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoIssuingLottoMachine {

    private static final List<LottoNumber> allNumbers = new ArrayList<>();

    public AutoIssuingLottoMachine() {
        for (int num = LottoNumber.LOTTO_MIN_NUMBER; num <= LottoNumber.LOTTO_MAX_NUMBER; num++) {
            allNumbers.add(new LottoNumber(num));
        }
    }

    public List<LottoTicket> makeLottoTicket(int purchaseOfPrice) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        int LottoTicketCount = purchaseOfPrice / LottoPrice.LOTTO_MIN_PRICE;
        for (int makeCount = 0; makeCount < LottoTicketCount; makeCount++) {
            Collections.shuffle(allNumbers);
            List<LottoNumber> lottoNumbers = allNumbers.subList(0, LottoTicket.LOTTO_NUMBERS_COUNT);
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }
        return lottoTickets;
    }


}
