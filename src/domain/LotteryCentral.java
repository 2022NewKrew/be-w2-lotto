package domain;

import domain.tickets.*;
import view.View;

import java.util.ArrayList;
import java.util.List;

// 로또 관리 본부 객체
// 본부는 구매자에게 자동발매 티켓 지급, 그리고 로또 추첨을 담당한다.
public class LotteryCentral {
    private TicketMachine ticketMachine = new TicketMachine();
    private WinningTicket winningTicket;

    // ============================ 티켓 꾸러미 Tickets 발행 ============================
    public Tickets releaseTickets(List<List<Integer>> manualList, int buyerPaid) {
        Tickets tickets = new Tickets();
        int numOfManualTickets = manualList.size();
        int numOfAutoTickets = (int) (buyerPaid - getManualTicketPrice() * numOfManualTickets) / getAutoTicketPrice();
        // 수동 티켓 발행
        for (int i = 0; i < numOfManualTickets; i++) {
            tickets.add(this.ticketMachine.makeManualTicket(manualList.get(i)));
        }
        // 자동 티켓 발행
        for (int i = 0; i < numOfAutoTickets; i++) {
            tickets.add(this.ticketMachine.makeAutoTicket());
        }
        return tickets;
    }

    // ============================ 로또 추첨 ============================
    public void drawWinningTicket(List<Integer> winningNumbers, int bonusball) {
        this.winningTicket = new WinningTicket(winningNumbers, bonusball);
    }

    public WinningTicket getWinningTicket() {
        return this.winningTicket;
    }

    public int getManualTicketPrice() {
        return ticketMachine.manualTicket.getPrice();
    }

    public int getAutoTicketPrice() {
        return ticketMachine.autoTicket.getPrice();
    }
}

