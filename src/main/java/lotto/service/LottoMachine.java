package lotto.service;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeType;
import lotto.dto.LottoResultDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static List<LottoTicket> createAutoLottoTickets(int purchaseCount) {
        return Stream.generate(LottoMachine::createAutoLottoTicket)
                .limit(purchaseCount)
                .collect(Collectors.toList());
    }

    private static LottoTicket createAutoLottoTicket() {
        return new LottoTicket(LottoNumbersFactory.createRandomLottoNumbers());
    }

    public static List<LottoTicket> createManualLottoTickets(List<LottoNumbers> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public static LottoResultDTO getLottoResult(List<LottoTicket> lottoTickets, LottoNumbers winningNumbers, int bonusNumber) {
        LottoResultDTO lottoResultDTO = new LottoResultDTO();
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getLottoMatchCount(winningNumbers);
            boolean matchBonus = lottoTicket.hasBonusNumber(bonusNumber);

            countLottoResult(lottoResultDTO, matchCount, matchBonus);
        }
        return lottoResultDTO;
    }

    private static void countLottoResult(LottoResultDTO lottoResultDTO, int matchCount, boolean matchBonus) {
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);
        if (prizeType != null) {
            prizeType.count(lottoResultDTO);
        }
    }
}
