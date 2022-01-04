package view;

import java.util.ArrayList;
import java.util.List;

public class Outputs {
    private final String LOTTO_STATISTIC_MESSEGE = "당첨 통계\n";
    private final String LINE_MESSEGE = "--------\n";
    private final String BUYING_RESULT_MESSEGE = "%d개를 구매했습니다.\n";
    private final String EARNING_RATE_MESSEGE = "총 수익률은 %.3f%%입니다.\n";
    private final String REWARDS_MESSEGE = "%d개 일치 (%d원)- %d개\n";

    public Outputs() {}

    public void printBuyingResult(int cnt) {
        System.out.printf(BUYING_RESULT_MESSEGE, cnt);
    }

    public void printResultStart() {
        System.out.printf(LOTTO_STATISTIC_MESSEGE);
        System.out.printf(LINE_MESSEGE);
    }

    public void printHavingTickets(List<List> lottoTickets) {  // 보유 중인 티켓들을 출력
        for (List lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printRewards(int hitCount, int reward, int hitTicketCount) {
        System.out.printf(REWARDS_MESSEGE, hitCount, reward, hitTicketCount);
    }

    public void printEarningRate(float earningRate) {
        System.out.printf(EARNING_RATE_MESSEGE, earningRate);
    }
}
