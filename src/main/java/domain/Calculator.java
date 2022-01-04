package domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public List<Integer> getRankCountList(List<List> lottoTickets, List<Integer> winningNumbers) {
        List<Integer> rankCountList = new ArrayList<>(); //  1등, 2등 ... 당첨 안된 티켓의 수를 저장
        for (int i = 0; i < 5; i++) {
            rankCountList.add(0);
        }
        for (List lottoTicket : lottoTickets) {
            int rankingIdx = getTicketRanking(lottoTicket, winningNumbers);
            rankCountList.set(rankingIdx, rankCountList.get(rankingIdx) + 1);
        }
        return rankCountList;
    }

    public int getTicketRanking(List<Integer> ticket, List<Integer> winningNumbers) {  // 해당 티켓의 등수를 계산
        int hitCount = 0;
        for (int i = 0; i < 6; i++) {
            hitCount += checkHitNumber(ticket, winningNumbers.get(i));
        }
        return getRankingIdx(hitCount);
    }

    public int getRankingIdx(int hitCount) {
        if (hitCount < 3) {
            return 4;
        }
        return 6 - hitCount;
    }

    public int checkHitNumber(List<Integer> ticket, int hitNumber) {
        if (ticket.contains(hitNumber)) {
            return 1;
        }
        return 0;
    }
}