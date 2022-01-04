package Lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ticket {
    private final List<Integer> numberCards = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private final List<Integer> ticket;

    Ticket(){
        this.ticket = new ArrayList<>();
        this.makeRandomNum();
    }

    public List<Integer> getTicket(){return this.ticket;}

    // 보너스 숫자를 확인하는 메소드
    public boolean checkBonusNum(int bonusNum){
        return this.ticket.contains(bonusNum);
    }

    // 숫자카드 섞기 메소드
    private void shuffleNumberCards(){
        Collections.shuffle(this.numberCards);
    }

    // 티켓 자동추첨 메소드
    private void makeRandomNum(){
        this.shuffleNumberCards();
        List<Integer> picked = numberCards.subList(0,6);
        Collections.sort(picked);
        for(Integer pick : picked)
            this.ticket.add(pick);
    }
}
