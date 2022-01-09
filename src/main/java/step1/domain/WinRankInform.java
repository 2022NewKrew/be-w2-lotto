package step1.domain;

import java.util.List;

public class WinRankInform {

    private final int reward;
    private final int matchCondition;
    private int winCount = 0;

    WinRankInform(int reward, int matchCondition) {
        this.reward = reward;
        this.matchCondition = matchCondition;
    }

    void findSatisfiedConditionTicket(List<LotteryTicket> tickets, List<Integer> winTicketNumbers) {
        for (LotteryTicket ticket : tickets) {
            winCount += isTicketMatchRankCondition(ticket, winTicketNumbers);
        }
    }

    private int isTicketMatchRankCondition(LotteryTicket ticket, List<Integer> winTicketNumbers) {
        int c = 0;
        for (int number : winTicketNumbers) {
            c += isTicketContainNumber(ticket, number);
        }

        if (c == matchCondition)
            return 1;
        return 0;
    }

    private int isTicketContainNumber(LotteryTicket ticket, int number) {
        if (ticket.getNumbersData().contains(number))
            return 1;
        return 0;
    }

    public int getTotalReward() {
        return winCount * reward;
    }

    public int getMatchCondition() {
        return matchCondition;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getReward() {
        return reward;
    }
}
