package com.cold.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class GameLogic {

    private Integer PRICE_PER_TICKET = 1000;
    private Integer MIN_WINNING_MATCHES = 3;
    private Integer CHECK_BONUS_BALL_MATCHES_COUNT = 5;
    private Integer MAX_WINNING_MATCHES = 7;
    private Integer MAP_BONUS_MATCH_KEY = 7;

    public Map<Integer, Integer> result;
    private double profitRate;

    private void initResult() {
        result = new HashMap<>() {
            {
                put(3, 0);
                put(4, 0);
                put(5, 0);
                put(6, 0);
                put(7, 0);
            }
        };
    }

    public void setProfitRate(int purchaseCount) {
        double spentMoney = purchaseCount * PRICE_PER_TICKET;
        double earnedMoney = calculateProfit();
        profitRate = calculateProfitRate(spentMoney, earnedMoney);
    }

    private double calculateProfitRate(double spentMoney, double earnedMoney) {
        return (earnedMoney - spentMoney) * 100 / spentMoney;
    }

    private int calculateProfit() {
        int sum = 0;
        for (Integer key : result.keySet()) {
            sum += checkEachCase(key);
        }
        return sum;
    }

    private int checkEachCase(Integer key) {
        if (result.get(key) != 0) {
            return getWinningReward(key);
        }
        return 0;
    }

    private int getWinningReward(Integer key) {
        return Prices.values()[key - 3].getWinningReward();
    }

    public void setResult(WholeTickets wholeTickets, WinningLotto winningLotto) {
        initResult();
        checkWholeTickets(wholeTickets, winningLotto);
    }

    private void checkWholeTickets(WholeTickets wholeTickets, WinningLotto winningLotto) {
        for (SingleTicket ticket : wholeTickets.getTickets()) {
            checkEachTicket(ticket, winningLotto);
        }
    }

    private void checkEachTicket(SingleTicket ticket, WinningLotto winningLotto) {
        int cnt = countMatches(ticket, winningLotto);
        insertIntoResult(cnt);
    }

    private int countMatches(SingleTicket ticket, WinningLotto winningLotto) {
        int cnt = countNormalMatches(ticket, winningLotto);
        if (cnt == CHECK_BONUS_BALL_MATCHES_COUNT) {
            return checkBonusMatch(ticket, winningLotto, cnt);
        }
        return cnt;
    }

    private int checkBonusMatch(SingleTicket ticket, WinningLotto winningLotto, int cnt) {
        if (ticket.getNumbers().contains(winningLotto.getBonusBall())) {
            return MAP_BONUS_MATCH_KEY;
        }
        return cnt;
    }

    private int countNormalMatches(SingleTicket ticket, WinningLotto winningLotto) {
        int cnt = 0;
        for (Integer num : ticket.getNumbers()) {
            cnt += checkEachNum(num, winningLotto);
        }
        return cnt;
    }

    private void insertIntoResult(int cnt) {
        if (cnt >= MIN_WINNING_MATCHES && cnt <= MAX_WINNING_MATCHES) {
            result.put(cnt, result.get(cnt) + 1);
        }
    }

    private int checkEachNum(Integer num, WinningLotto winningLotto) {
        return winningLotto.getLastWinningNums().contains(num) ? 1 : 0;
    }
}

