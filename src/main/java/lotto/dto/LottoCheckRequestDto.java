package lotto.dto;

import lotto.domain.ticket.Ticket;

import java.util.List;

public class LottoCheckRequestDto {

    private final List<Integer> winningNumberList;
    private final int bonusNumber;
    private final List<Ticket> ticketBundle;

    public LottoCheckRequestDto(List<Integer> winningNumberList, int bonusNumber, List<Ticket> ticketBundle) {
        this.winningNumberList = winningNumberList;
        this.bonusNumber = bonusNumber;
        this.ticketBundle = ticketBundle;
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Ticket> getLottoBundle() {
        return ticketBundle;
    }
}
