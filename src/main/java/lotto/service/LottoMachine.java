package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.PrizeType;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static List<LottoTicket> createAutoLottoTickets(int purchaseCount) {
        return Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(purchaseCount)
                .collect(Collectors.toList());
    }

    public static LottoResult getLottoResult(List<LottoTicket> lottoTickets, LottoTicket winningNumbers, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getLottoMatchCount(winningNumbers);
            boolean matchBonus = lottoTicket.hasNumber(bonusNumber);

            countLottoResult(lottoResult, matchCount, matchBonus);
        }
        return lottoResult;
    }

    private static void countLottoResult(LottoResult lottoResult, int matchCount, boolean matchBonus) {
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);
        if (prizeType != null) {
            prizeType.count(lottoResult);
        }
    }
}
