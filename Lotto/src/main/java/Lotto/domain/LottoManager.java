package Lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    List<Ticket> tickets;
    List<Integer> results;
    private int investmentAmount;
    private int numberOfTicket;
    private int bonusNumber;

    public LottoManager(){
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets(){return this.tickets;}
    public List<Integer> getResults(){return this.results;}
    public int getInvestmentAmount(){return this.investmentAmount;}
    public int getBonusNumber(){return this.bonusNumber;}

    public void setResults(List<Integer> results){this.results = results;}
    public void setBonusNumber(int bonusNumber){this.bonusNumber = bonusNumber;}

    // 가격에 맞게 로또를 구매하는 메소드
    public void buyTickets(int price){
        this.investmentAmount = price;
        this.numberOfTicket = price / 1000;
        for(int num=0; num<numberOfTicket; num++) {
            this.tickets.add(new Ticket());
        }
    }
}
