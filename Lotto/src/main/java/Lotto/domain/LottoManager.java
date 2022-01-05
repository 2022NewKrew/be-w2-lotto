package Lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    List<Ticket> randomTickets;
    List<Ticket> manualTickets;
    List<Integer> winingNumber;
    private int investmentAmount;
    private int bonusNumber;
    private int countOfTickets;
    private int countOfManualTickets;
    private int countOfRandomTickets;

    public LottoManager(){
        this.randomTickets = new ArrayList<>();
    }

    public List<Ticket> getRandomTickets(){return this.randomTickets;}
    public List<Ticket> getManualTickets(){return this.manualTickets;}
    public List<Integer> getWiningNumber(){return this.winingNumber;}
    public int getInvestmentAmount(){return this.investmentAmount;}
    public int getBonusNumber(){return this.bonusNumber;}

    public void setWiningNumber(List<Integer> winingNumber){this.winingNumber = winingNumber;}
    public void setBonusNumber(int bonusNumber){this.bonusNumber = bonusNumber;}

    // 가격에 맞게 로또를 구매하는 메소드
    public void buyTickets(int price, List<Ticket> manualTickets){
        this.investmentAmount = price;
        this.manualTickets = manualTickets;
        this.countOfManualTickets = manualTickets.size();
        this.countOfTickets = price / 1000;
        this.countOfRandomTickets = this.countOfTickets - this.countOfManualTickets;
        for(int num=0; num<this.countOfRandomTickets; num++) {
            this.randomTickets.add(new Ticket());
        }
    }
}
