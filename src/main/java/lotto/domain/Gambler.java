package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Gambler {
    private final List<LottoTicket> tickets;

    public Gambler(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    /**
     * @param winnerNumber 1등 번호
     * @param bonusBall 보너스 숫자
     * @return
     * <pre>{@code
     *     Map<Prize, 횟수>
     * }</pre>
     */
    public Map<Prize, Long> getMatchingResult(Set<Integer> winnerNumber, int bonusBall) {
        return tickets.stream()
                .map(ticket -> ticket.matchWithWinnerNumber(winnerNumber, bonusBall))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
