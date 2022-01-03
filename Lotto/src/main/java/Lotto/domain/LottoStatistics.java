package Lotto.domain;

import java.util.List;

public class LottoStatistics {
    private int matched3num;
    private int matched4num;
    private int matched5num;
    private int matched6num;
    private int profit;
    private int rateOfProfit;

    public LottoStatistics(){
        this.matched3num = 0;
        this.matched4num = 0;
        this.matched5num = 0;
        this.matched6num = 0;
        this.rateOfProfit = 0;
    }

    public int getMatched3num(){return this.matched3num;}
    public int getMatched4num(){return this.matched4num;}
    public int getMatched5num(){return this.matched5num;}
    public int getMatched6num(){return this.matched6num;}
    public int getRateOfProfit(){return this.rateOfProfit;}

    // 맞은 숫자의 개수에 따라 멤버변수의 개수를 증가하는 메소드
    private void increaseMatchedNum(int num){
        if(num == 3){ this.matched3num++; return;}
        if(num == 4){ this.matched3num++; return;}
        if(num == 5){ this.matched3num++; return;}
        if(num == 6){ this.matched3num++; return;}
    }

    // 해당 숫자가 복권에 있는 숫자면 1을 반환, 그렇지 않으면 0을 반환하는 메소드
    private int isMatched(int result, List<Integer> ticket){
        if(ticket.contains(result))
            return 1;
        return 0;
    }

    // 해당복권의 맞은 개수를 반환하는 메소드
    private int matchingResults(List<Integer> ticket, List<Integer> results){
        int matchedNum = 0;
        for(Integer result : results)
            matchedNum += this.isMatched(result, ticket);
        return matchedNum;
    }

    // 구입한 복권들로 얻은 수익을 계산하는 메소드
    private void calculateProfit(){
        this.profit = this.matched3num*5000 + this.matched4num*50000 + this.matched5num*1500000 + this.matched6num*2000000000;
    }

    // 로또 통계를 계산하는 메소드
    public void calculateStatistics(int investmentAmount, List<Ticket> tickets, List<Integer> results){
        for(Ticket ticket : tickets) {
            this.increaseMatchedNum(matchingResults(ticket.getTicket(), results));
        }
        this.calculateProfit();
        this.rateOfProfit = this.profit * 100 / investmentAmount;
    }
}
