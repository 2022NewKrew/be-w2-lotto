package Lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> countOfWining = new LinkedHashMap<>();
    private long profit;
    private long rateOfProfit;

    public LottoStatistics(int investmentAmount, List<Ticket> manualTickets, List<Ticket> randomTickets, List<Integer> results, int bonusNumber){
        this.countOfWining.put(Rank.FIRST, 0);
        this.countOfWining.put(Rank.SECOND, 0);
        this.countOfWining.put(Rank.THIRD, 0);
        this.countOfWining.put(Rank.FOURTH, 0);
        this.countOfWining.put(Rank.FIFTH, 0);
        this.rateOfProfit = 0;
        this.calculateStatistics(investmentAmount, manualTickets, randomTickets, results, bonusNumber);
    }

    public Map<Rank, Integer> getCountOfWining(){return this.countOfWining;}
    public long getRateOfProfit(){return this.rateOfProfit;}

    // 맞은 숫자의 개수에 따라 카운트를 증가하는 메소드
    private void increaseMatchedNum(int matchedNum, boolean isMatchedBonus){
        if(matchedNum > 2){
            Rank rank = Rank.value(matchedNum, isMatchedBonus);
            countOfWining.put(rank, countOfWining.get(rank) + 1);
        }
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
        this.profit = this.countOfWining.get(Rank.FIFTH) * Rank.FIFTH.getEarnedMoney()
                + this.countOfWining.get(Rank.FOURTH) * Rank.FOURTH.getEarnedMoney()
                + this.countOfWining.get(Rank.THIRD) * Rank.THIRD.getEarnedMoney()
                + this.countOfWining.get(Rank.SECOND) * Rank.SECOND.getEarnedMoney()
                + this.countOfWining.get(Rank.FIRST) * Rank.FIRST.getEarnedMoney();
    }

    // 로또 통계를 계산하는 메소드
    private void calculateStatistics(int investmentAmount, List<Ticket> manualTickets, List<Ticket> randomTickets, List<Integer> winingNumber, int bonusNumber){
        for(Ticket ticket : manualTickets) {
            this.increaseMatchedNum(matchingResults(ticket.getTicket(), winingNumber), ticket.checkBonusNum(bonusNumber));
        }
        for(Ticket ticket : randomTickets) {
            this.increaseMatchedNum(matchingResults(ticket.getTicket(), winingNumber), ticket.checkBonusNum(bonusNumber));
        }
        this.calculateProfit();
        this.rateOfProfit = this.profit * 100 / investmentAmount;
    }
}
