package be.w2.lotto.domain.numbergenerator;

import be.w2.lotto.domain.lottoticket.LottoTicket;
import be.w2.lotto.domain.lottoticket.ManualLottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements LottoNumberGeneratable {
    public ManualLottoNumberGenerator() {}

    @Override
    public List<LottoTicket> generateLottoTickets(int numberCount, List<List<Integer>> manualLottoTicket) {
        return manualLottoTicket.stream()
                .map(ManualLottoTicket::valueOf)
                .collect(Collectors.toList());
    }
}
