package be.w2.lotto.domain.numbergenerator;

import be.w2.lotto.domain.lottoticket.LottoTicket;

import java.util.List;

public interface LottoNumberGeneratable {
    List<LottoTicket> generateLottoNumbers(int numberCount, List<List<Integer>> lottoTicket);
}
