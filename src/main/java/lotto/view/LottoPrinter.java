package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.LottoMatchingResult;
import lotto.domain.Prize;

import java.util.Set;

public class LottoPrinter {

    /**
     * 로또 당첨 결과 출력
     */
    public void printLottoResult(LottoTickets lottoTickets, Set<Integer> winnerNumber, int bonusBall) {
        LottoMatchingResult matchingResult = lottoTickets.getMatchingResult(winnerNumber, bonusBall);

        printLottoMatchingResult(matchingResult);
        printLottoEarningsRate(matchingResult);
    }

    private void printLottoMatchingResult(LottoMatchingResult matchingResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for (Prize prize : Prize.values()) {
            System.out.printf("%d개 일치 %s (%d원) - %d개%n", prize.getMatchedCount(),
                    (prize.isBonusBallMatched() ? "+ 보너스 볼" : ""),
                    prize.getMoney(), matchingResult.getOccurrences(prize));
        }
    }

    private void printLottoEarningsRate(LottoMatchingResult matchingResult) {
        System.out.println();
        System.out.printf("총 수익률은 %2.0f%%입니다.%n", matchingResult.getEarningsRate());
    }
}
