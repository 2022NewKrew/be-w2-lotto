package Lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoManager {
    List<Ticket> tickets;
    List<Integer> numberCards;
    List<Integer> results;
    private int investmentAmount;
    private int numberOfTicket;

    public LottoManager(){
        this.tickets = new ArrayList<Ticket>();
        this.makeNumberCards();
    }

    public List<Ticket> getTickets(){return this.tickets;}
    public List<Integer> getResults(){return this.results;}
    public int getInvestmentAmount(){return this.investmentAmount;}
    public int getNumberOfTicket(){return this.numberOfTicket;}

    public void setResults(List<Integer> results){this.results = results;}

    // 숫자카드 덱 만들기 메소드
    private void makeNumberCards(){
        this.numberCards = new ArrayList<>();
        for(int num=1;num<=45;num++) this.numberCards.add(num);
    }

    // 숫자카드 섞기 메소드
    private void shuffleNumberCards(){
        Collections.shuffle(this.numberCards);
    }

    // 가격에 맞게 로또를 구매하는 메소드
    public void buyTickets(int price){
        this.investmentAmount = price;
        this.numberOfTicket = price / 1000;
        for(int num=0; num<numberOfTicket; num++) {
            this.shuffleNumberCards();
            this.tickets.add(new Ticket(this.numberCards));
        }
    }
}
