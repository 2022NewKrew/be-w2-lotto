package domain;

import exceptions.InvalidManualTicketCount;
import exceptions.InvalidPurchaseAmount;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import messages.ErrorMessage;
import validation.Validation;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRISE = 0;
    private static final int MAX_PRISE = 1_000_000_000;
    private static final ManualLottoTicketGenerator manualLottoTicketGenerator = new ManualLottoTicketGenerator();
    private static final RandomLottoTicketGenerator randomLottoTicketGenerator = new RandomLottoTicketGenerator();

    public LottoMachine() {
    }

    private List<LottoTicket> buyManualTickets(long count, List<Set<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(manualLottoTicketGenerator::generate)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> buyRandomTickets(long count) {
        return Stream.generate(() -> randomLottoTicketGenerator.generate(null))
                .limit(count)
                .collect(Collectors.toList());
    }

    public LottoTickets buyLottoTickets(long purchaseAmount, List<Set<Integer>> manualNumbers) {
        Validation.notLessThanLong(purchaseAmount, MIN_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        Validation.notMoreThanLong(purchaseAmount, MAX_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.MAX_PURCHASE_AMOUNT.getMessage()));

        long lottoCount = purchaseAmount / LOTTO_PRICE;
        long manualCount = lottoCount - manualNumbers.size();
        Validation.notLessThanLong(lottoCount, manualCount,
                () -> new InvalidManualTicketCount(ErrorMessage.MANUAL_TICKET_EXCEED_PURCHASE_AMOUNT.getMessage()));

        List<LottoTicket> manualTickets = buyManualTickets(manualCount, manualNumbers);
        List<LottoTicket> randomTickets = buyRandomTickets(lottoCount - manualCount);

        return new LottoTickets(manualTickets, randomTickets);
    }
}
