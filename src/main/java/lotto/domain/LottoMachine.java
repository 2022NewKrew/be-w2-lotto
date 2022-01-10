package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int TICKET_PRICE = 1000;
    private final LottoNumbersGenerator randomGenerator;
    private final LottoNumbersGenerator manualGenerator;

    public LottoMachine(LottoNumbersGenerator randomGenerator, LottoNumbersGenerator manualGenerator) {
        this.randomGenerator = randomGenerator;
        this.manualGenerator = manualGenerator;
    }

    public LottoTickets issue(LottoTicketCount autoTicketCount, LottoTicketCount manualTicketCount, List<String[]> manualLottoNumbers) {
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
