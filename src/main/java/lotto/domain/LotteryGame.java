package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryGame {
    public final int numTickets;
    public final int numManualTickets;
    public final List<Ticket> ticketList;


    private void addTickets() {
        for (int i=0; i<numTickets-numManualTickets; i++) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
        }
    }

    private void addGameBoardEntry(Map<Integer, Integer> gameBoard, int matches, List<Integer> ticketNumber, int bonusNumber) {
        LotteryConstants.PrizeMoney SECOND = LotteryConstants.PrizeMoney.SECOND;
        if (matches==SECOND.matches && ticketNumber.contains(bonusNumber)) {
            gameBoard.put(SECOND.rank, gameBoard.getOrDefault(SECOND.rank, 0)+1);
            return;
        }
        for (LotteryConstants.PrizeMoney prize: LotteryConstants.PrizeMoney.values()) {
            if (matches==prize.matches) {
                gameBoard.put(prize.rank, gameBoard.getOrDefault(prize.rank, 0)+1);
            }
        }
    }

    public Map<Integer, Integer> getResult(WinningTicket winningTicket) {
        Map<Integer, Integer> gameBoard = new HashMap<>();

        for (Ticket ticket: ticketList) {
            List<Integer> ticketNumber = ticket.getTicketNumbers();
            int matches = ticketNumber.stream().distinct().filter(winningTicket.getTicketNumbers()::contains).collect(Collectors.toSet()).size();
            addGameBoardEntry(gameBoard, matches, ticketNumber, winningTicket.getBonusNumber());
        }
        return gameBoard;
    }

    public LotteryGame(List<Ticket> manualTickets, int numTickets) {
        this.numTickets = numTickets;
        this.numManualTickets = manualTickets.size();
        ticketList = new ArrayList<>(manualTickets);
        addTickets();
    }
}
