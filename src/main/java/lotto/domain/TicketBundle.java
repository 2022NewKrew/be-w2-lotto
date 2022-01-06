package lotto.domain;

import lotto.domain.generator.Generator;
import lotto.domain.generator.ManualGenerator;
import lotto.domain.generator.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class TicketBundle {

    private static final String NEWLINE = System.lineSeparator();
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final RandomGenerator randomIssuePolicy = new RandomGenerator();
    private final List<Ticket> ticketBundle = new ArrayList<>();

    private TicketBundle() {}

    public static TicketBundle purchaseLottoBundle(int totalPurchaseCount, int manualPurchaseCount, List<List<Integer>> lottoNumbersList) {
        TicketBundle ticketBundle = new TicketBundle();
        for (int i = 0; i < manualPurchaseCount; i++) {
            ticketBundle.addLotto(manualPurchaseCount, new ManualGenerator(lottoNumbersList.get(i)));
        }
        ticketBundle.addLotto(totalPurchaseCount - manualPurchaseCount, randomIssuePolicy);
        return ticketBundle;
    }

    public void addLotto(int purchaseAmount, Generator issuePolicy) {
        this.ticketBundle.addAll(lottoMachine.purchaseLotto(purchaseAmount, issuePolicy));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Ticket ticket : ticketBundle) {
            sb.append(ticket.printNumberList());
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public List<Ticket> getLottoBundle() {
        return ticketBundle;
    }
}
