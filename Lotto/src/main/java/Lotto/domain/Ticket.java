package Lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {
    private List<Integer> ticket;

    Ticket(){}
    Ticket(List<Integer> numberCards){
        this.ticket = new ArrayList<>();
        this.makeRandomNum(numberCards);
    }

    public List<Integer> getTicket(){return this.ticket;}

    // 티켓 자동추첨 메소드
    private void makeRandomNum(List<Integer> numberCards){
        List<Integer> picked = numberCards.subList(0,6);
        Collections.sort(picked);
        for(Integer pick : picked)
            this.ticket.add(pick);
    }
}
