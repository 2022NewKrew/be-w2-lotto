package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int TICKET_PRICE = 1000;
    private static final LottoNumbersGenerator randomGenerator = new RandomLottoNumberGenerator();
    private static final LottoNumbersGenerator manualGenerator = new ManualLottoNumberGenerator();

    private LottoMachine() {
    }

    public static LottoTickets issue(LottoTicketCount autoTicketCount, LottoTicketCount manualTicketCount, List<String[]> manualLottoNumbers) {
        List<LottoTicket> tickets = IntStream.range(0, manualTicketCount.getCount())
                .mapToObj(manualLottoNumbers::get)
                .map(manualGenerator::generateLottoNumbers)
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        IntStream.range(0, autoTicketCount.getCount())
                .mapToObj(i -> randomGenerator.generateLottoNumbers(null))
                .map(LottoTicket::new)
                .forEach(tickets::add);

        return LottoTickets.from(tickets);
    }
}
