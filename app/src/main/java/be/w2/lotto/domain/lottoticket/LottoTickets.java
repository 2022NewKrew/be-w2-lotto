package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.*;
import be.w2.lotto.domain.numbergenerator.AutoLottoNumberGenerator;
import be.w2.lotto.domain.numbergenerator.LottoNumberGeneratable;
import be.w2.lotto.domain.numbergenerator.ManualLottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets valueOf(int lottoPurchaseAmount, List<List<Integer>> manualLottoNumbers) {
        int lottoAmount = getLottoAmount(lottoPurchaseAmount);
        List<LottoTicket> lottoTickets = createLottoTickets(lottoAmount, manualLottoNumbers);
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    private static int getLottoAmount(int lottoPurchaseAmountInput) {
        LottoAmount.validatePurchaseAmount(lottoPurchaseAmountInput);
        return LottoAmount.getLottoAmount(lottoPurchaseAmountInput);
    }

    private static List<LottoTicket> createLottoTickets(int lottoAmount, List<List<Integer>> manualLottoNumbers) {
        int autoNumberCount = lottoAmount - manualLottoNumbers.size();
        return lottoNumberGeneratables.stream()
                .map(lottoNumberGeneratable ->
                    lottoNumberGeneratable instanceof AutoLottoNumberGenerator ?
                            lottoNumberGeneratable.generateLottoNumbers(autoNumberCount, null) :
                            lottoNumberGeneratable.generateLottoNumbers(manualLottoNumbers.size(), manualLottoNumbers)
                )
                .collect(Collectors.toList()).stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static final List<LottoNumberGeneratable> lottoNumberGeneratables = List.of(
            new AutoLottoNumberGenerator(),
            new ManualLottoNumberGenerator()
    );

    public static final int LOTTO_TICKET_SIZE = 6;
}
