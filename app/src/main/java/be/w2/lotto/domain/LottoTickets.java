package be.w2.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets valueOf(int lottoPurchaseAmount) {
        int lottoAmount = getLottoAmount(lottoPurchaseAmount);
        List<LottoTicket> lottoTickets = createLottoTickets(lottoAmount);
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    private static int getLottoAmount(int lottoPurchaseAmountInput) {
        LottoAmount.validatePurchaseAmount(lottoPurchaseAmountInput);
        return LottoAmount.getLottoAmount(lottoPurchaseAmountInput);
    }

    private static List<LottoTicket> createLottoTickets(int lottoAmount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++) {
            List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
            lottoTickets.add(LottoTicket.from(lottoNumbers));
        }
        return lottoTickets;
    }

    public static final int LOTTO_TICKET_SIZE = 6;
}
