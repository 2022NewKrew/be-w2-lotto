package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.PrizeType;
import lotto.dto.LottoResultDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<LottoTicket> createLottoTickets(int purchaseCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

    public static LottoResultDTO getLottoResult(List<LottoTicket> lottoTickets, List<Integer> winningNumbers) {
        LottoResultDTO lottoResultDTO = new LottoResultDTO();
        for (LottoTicket lottoTicket : lottoTickets) {
            countLottoResult(lottoResultDTO, lottoTicket.getLottoMatchCount(winningNumbers));
        }
        return lottoResultDTO;
    }

    private static void countLottoResult(LottoResultDTO lottoResultDTO, int matchCount) {
        if (matchCount == PrizeType.FIRST_PRIZE.getValue()) {
            lottoResultDTO.plusFirstPrizeCount();
        } else if (matchCount == PrizeType.SECOND_PRIZE.getValue()) {
            lottoResultDTO.plusSecondPrizeCount();
        } else if (matchCount == PrizeType.THIRD_PRIZE.getValue()) {
            lottoResultDTO.plusThirdPrizeCount();
        } else if (matchCount == PrizeType.FOURTH_PRIZE.getValue()) {
            lottoResultDTO.plusFourthPrizeCount();
        }
    }
}
