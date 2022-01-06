package domain;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public Map<LottoPrize, Long> getWinningStatus(List<Integer> lastWeekWinningNumbers, int bonusBallNumber) {
       return lottoTickets.stream().collect(groupingBy(purchasedLottoTicket ->
                        LottoPrize.getLottoRank(numberOfSameNumbers(purchasedLottoTicket ,lastWeekWinningNumbers), isMatchBonusBall(purchasedLottoTicket, bonusBallNumber)), counting()));
    }

    private boolean isMatchBonusBall(LottoTicket lottoTicket, int bonusBallNumber) {
        return lottoTicket.getLottoNumbers().contains(bonusBallNumber);
    }

    private long numberOfSameNumbers(LottoTicket lottoTicket, List<Integer> lastWeekWinningNumbers) {
        Set<Integer> lottoTicketNumbers = new HashSet<>(lottoTicket.getLottoNumbers());

        return lastWeekWinningNumbers.stream().filter(number -> !lottoTicketNumbers.add(number)).count();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
