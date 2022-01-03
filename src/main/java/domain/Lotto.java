package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static domain.LottoGameInfo.PRIZE_OF_LOTTO;

public class Lotto {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();
    private final List<Integer> lottoResult = new ArrayList<>();
    private int profit = 0;

    public Lotto() {
        IntStream.rangeClosed(0, 6)
                .forEach(number -> lottoResult.add(0));
    }

    public int getProfit() {
        return profit;
    }

    public void addTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public void calculateResult(List<Integer> winningNumbers) {
        for(LottoTicket ticket: lottoTickets) {
            int numberOfMatched = ticket.getNumberOfMatched(winningNumbers);
            lottoResult.set(numberOfMatched, lottoResult.get(numberOfMatched) + 1);
            profit += PRIZE_OF_LOTTO.get(ticket.getNumberOfMatched(winningNumbers));
        }
    }

    public void printTickets() {
        for (LottoTicket ticket: lottoTickets)
            System.out.println(ticket.toString());
    }

    public void printResult(int numberOfMatched) {
        System.out.print(lottoResult.get(numberOfMatched));
    }
}
