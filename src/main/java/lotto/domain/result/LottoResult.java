package lotto.domain.result;

import lotto.domain.component.WinningLottoTicket;
import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoTicket;

import lotto.dto.GetLottoResultDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final int ZERO = 0;
    private final int purchasePrice;
    private final Map<LottoResultType, Integer> matchingResult = new HashMap<>();



    public LottoResult(GetLottoResultDTO getLottoResultDTO) {
        this.purchasePrice = getLottoResultDTO.getPurchasePrice();
        initialize();
        compareLottoNumber(getLottoResultDTO.getWinningLottoTicket(),
                getLottoResultDTO.getLottoTickets());

    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public Map<LottoResultType, Integer> getMatchResult() {
        return matchingResult;
    }

    private void initialize() {
        for (LottoResultType resultType : LottoResultType.values()) {
            matchingResult.put(resultType, ZERO);
        }
    }

    private boolean checkBonusMatch(LottoTicket ticket, LottoNumber bonusBall) {
        return ticket.getLottoNumbers().contains(bonusBall);
    }

    private LottoResultType findResultType(int countOfMatchingNumber, boolean isBonusMatch) {
        LottoResultType resultType = LottoResultType.getLottoResultType(countOfMatchingNumber);
        if ((resultType == LottoResultType.FIVE_MATCH) && isBonusMatch) {
            return LottoResultType.FIVE_MATCH_WITH_BONUS;
        }
        return resultType;
    }

    private void increaseMatchingCount(int countOfMatchingNumber, boolean isBonusMatch) {
        matchingResult.computeIfPresent(findResultType(countOfMatchingNumber, isBonusMatch),
                (type, number) -> number + 1);
    }


    private void compareLottoNumber(WinningLottoTicket winningLottoTicket, List<LottoTicket> lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            int count = compareWinningNumber(winningLottoTicket.getWinningTicket(), ticket);
            if (count >= LottoResultType.MIN_MATCH_NUMBER_COUNT) {
                increaseMatchingCount(count,
                        checkBonusMatch(ticket, winningLottoTicket.getBonusBall()));
            }
        }
    }

    private int compareWinningNumber(LottoTicket winningTicket, LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers()
                .stream()
                .filter(lottoNumber -> winningTicket.getLottoNumbers().contains(lottoNumber))
                .count();
    }
}
