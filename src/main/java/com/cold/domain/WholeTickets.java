package com.cold.domain;

import java.util.*;

import lombok.Getter;

@Getter
public class WholeTickets {

    private Integer MIN_WINNING_MATCHES = 3;
    private Integer MAX_WINNING_MATCHES = 7;

    private List<SingleTicket> tickets;
    public Map<String, Integer> wholeResult;
    private double profitRate;

    public WholeTickets(int purchaseCount) {
        tickets = new ArrayList<>(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
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
        insertIntoResult(ticket.getMatches());
    }

    private void insertIntoResult(int count) {
        if (count >= MIN_WINNING_MATCHES && count <= MAX_WINNING_MATCHES) {
            String countString = Prices.getKeyword(count);
            wholeResult.put(countString, wholeResult.get(countString) + 1);
        }
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public void addManualLotto(List<SingleTicket> manualLotto) {
        manualLotto.addAll(this.tickets);
        this.tickets = manualLotto;
    }
}
