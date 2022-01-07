package com.cold.models;

import java.util.*;

import com.cold.domain.Rank;
import lombok.Getter;

@Getter
public class WholeTickets {

    private Integer MIN_WINNING_MATCHES = 3;
    private Integer MAX_WINNING_MATCHES = 7;
    private static Integer PRICE_PER_TICKET = 1000;

    private List<SingleTicket> tickets;
    public Map<String, Integer> wholeResult;
    private double profitRate;

    public void initTickets(int autoLottoCount) {
        tickets = new ArrayList<>(autoLottoCount);
        for (int i = 0; i < autoLottoCount; i++) {
            tickets.add(new SingleTicket());
        }
    }

    public void calculateResult(WinningLotto winningLotto) {
        initResult();
        checkWholeTickets(winningLotto);
    }

    private void initResult() {
        wholeResult = new LinkedHashMap<>() {
            {
                put("THREE", 0);
                put("FOUR", 0);
                put("FIVE", 0);
                put("BONUS", 0);
                put("SIX", 0);
            }
        };
    }

    private void checkWholeTickets(WinningLotto winningLotto) {
        for (SingleTicket ticket : tickets) {
            checkEachTicket(ticket, winningLotto);
        }
    }

    private void checkEachTicket(SingleTicket ticket, WinningLotto winningLotto) {
        ticket.setMatches(winningLotto);
        insertIntoResult(ticket.getMatches(), ticket.getBonusMatch());
    }

    private void insertIntoResult(int count, Boolean bonusMatch) {
        if (count >= MIN_WINNING_MATCHES && count <= MAX_WINNING_MATCHES) {
            String countString = Rank.getKeyword(count, bonusMatch);
            wholeResult.put(countString, wholeResult.get(countString) + 1);
        }
    }

    public void setProfitRate() {
        this.profitRate = calculateProfitRate();
    }

    public double calculateProfitRate() {
        double spentMoney = calculateSpentMoney();
        double earnedMoney = calculateEarnedMoney();
        return (earnedMoney - spentMoney) * 100 / spentMoney;
    }

    private double calculateSpentMoney() {
        int purchaseCount = tickets.size();
        return purchaseCount * PRICE_PER_TICKET;
    }

    private int calculateEarnedMoney() {
        int sum = 0;
        for (String key : wholeResult.keySet()) {
            sum += checkEachCase(key).getWinningReward();
        }
        return sum;
    }

    private Rank checkEachCase(String key) {
        if (wholeResult.get(key) != 0) {
            return getWinningReward(key);
        }
        return Rank.EMPTY;
    }

    private Rank getWinningReward(String key) {
        return Rank.valueOf(key);
    }

    public void addManualLotto(List<SingleTicket> manualLotto) {
        tickets.addAll(manualLotto);
    }
}
