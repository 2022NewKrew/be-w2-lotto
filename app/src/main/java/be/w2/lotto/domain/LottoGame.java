package be.w2.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<LottoTicket> lottoTickets;

    private LottoGame(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoGame valueOf(int lottoPurchaseAmountInput) {
        int lottoAmount = getLottoAmount(lottoPurchaseAmountInput);
        List<LottoTicket> lottoTickets = createLottoTickets(lottoAmount);
        return new LottoGame(lottoTickets);
    }

    private static int getLottoAmount(int lottoPurchaseAmountInput) {
        LottoAmount lottoPurchaseAmount = LottoAmount.from(lottoPurchaseAmountInput);
        return lottoPurchaseAmount.getLottoAmount();
    }

    private static List<LottoTicket> createLottoTickets(int lottoAmount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++) {
            lottoTickets.add(LottoTicket.newInstance());
        }
        return lottoTickets;
    }
}
