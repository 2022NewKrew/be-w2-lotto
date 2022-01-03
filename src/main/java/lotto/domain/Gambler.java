package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gambler {
    private int money;
    private final List<LottoTicket> tickets = new ArrayList<>();

    public Gambler() {
        this(0);
    }

    public Gambler(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void buyLottoTicket(LottoTicket lottoTicket, int lottoTicketPrice) {
        money -= lottoTicketPrice;
        tickets.add(lottoTicket);
    }

    public void setMoneyFromScanner() {
        money = InputView.getPositiveIntFromScanner("구입금액을 입력해주세요: ");
    }
}
