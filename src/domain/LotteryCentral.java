package domain;

import domain.tickets.AutoTicket;
import domain.tickets.Ticket;
import domain.tickets.WinningTicket;
import view.View;

import java.util.ArrayList;
import java.util.List;

// 로또 관리 본부 객체
// 본부는 구매자에게 자동발매 티켓 지급, 그리고 로또 추첨을 담당한다.
public class LotteryCentral {
    private WinningTicket winningTicket;

    // ============================ 자동발매 티켓 지급 ============================
    // 자동발매 수를 입력받아 티켓들을 생성하여 티켓리스트를 돌려준다.
    public List<Ticket> releaseAutoTickets(int numOfAutoTickets) {
        // 발매해서 구매자에게 전달할 자동발매 티켓들을 저장하는 tickets
        List<Ticket> tickets = new ArrayList<>();
        // 자동 티켓 발매
        for (int i = 0; i < numOfAutoTickets; i++) {
            tickets.add(new AutoTicket());
        }
        return tickets;
    }

    // ============================ 로또 추첨 ============================
    // 당첨 티켓 정보 입력
    public void inputWinningTicket() {
        View.print("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = DataFormatting.selectedNumbers();
        View.print("보너스 볼을 입력해 주세요.");
        int bonusBall = DataFormatting.stringToInteger(View.inputString());
        this.winningTicket = new WinningTicket(winningNumbers, bonusBall);
    }

    public WinningTicket getWinningTicket() {
        return this.winningTicket;
    }

}

