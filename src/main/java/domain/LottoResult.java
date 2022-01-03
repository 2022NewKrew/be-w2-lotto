package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final int ZERO = 0;
    private final int purchasePrice;
    private final Map<LottoResultType, Integer> matchResult = new HashMap<>();


    public LottoResult(LottoTicket winningTicket, List<LottoTicket> lottoTickets, int purchasePrice) {
        this.purchasePrice = purchasePrice;
        initialize();
        compareLottoNumber(winningTicket, lottoTickets);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public Map<LottoResultType, Integer> getMatchResult() {
        return matchResult;
    }

    private void initialize() {
        for (LottoResultType resultType : LottoResultType.values()) {
            matchResult.put(resultType, ZERO);
        }
    }

    private void compareLottoNumber(LottoTicket winningTicket, List<LottoTicket> lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            int count = compareWinningNumber(winningTicket, ticket);
            LottoResultType resultType = LottoResultType.valueOf(Integer.toString(count));
            matchResult.computeIfPresent(resultType, (type, number) -> number + 1);
        }
    }

    private int compareWinningNumber(LottoTicket winningTicket, LottoTicket lottoTickets) {
        int matchCount = 0;
        if (winningTicket.getTickets().contains(lottoTickets)) {
            matchCount++;
        }
        return matchCount;
    }
}
