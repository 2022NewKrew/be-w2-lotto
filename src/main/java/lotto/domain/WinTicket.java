package lotto.domain;

import java.util.List;

public class WinTicket extends Ticket {

    private final TicketNumber bonusTicketNumber;

    public WinTicket(List<Integer> ticketNumbers, int bonusTicketNumber) {
        super(ticketNumbers);
        this.bonusTicketNumber = checkDuplicatedNumber(bonusTicketNumber);
    }

    private TicketNumber checkDuplicatedNumber(int bonusTicketNumber) {
        return ticketNumbers.checkDuplicatedNumber(bonusTicketNumber);
    }

    public Rank checkTicketRank(Ticket ticket) {
        int matchCount = ticket.getMatchedNumber(this);
        if (matchCount == 5) {
            return Rank.valueOf(matchCount, ticket.isBonusMatched(bonusTicketNumber));
        }
        return Rank.valueOf(matchCount, false);
    }
}
