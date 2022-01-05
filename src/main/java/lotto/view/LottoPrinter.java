package lotto.view;

import lotto.domain.Gambler;
import lotto.domain.LottoMatchingResult;
import lotto.domain.LottoShop;
import lotto.domain.Prize;

import java.util.Set;

public class LottoPrinter {

    public void printLottoResult(LottoShop lottoShop, Gambler gambler, int bonusBall) {
        Set<Integer> winnerNumber = lottoShop.getWinnerNumber();
        LottoMatchingResult matchingResult = gambler.getMatchingResult(winnerNumber, bonusBall);

        printLottoMatchingResult(matchingResult);
        printLottoEarningsRate(matchingResult);
    }

    private void printLottoMatchingResult(LottoMatchingResult matchingResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for (Prize prize : Prize.values()) {
            System.out.printf("%s - %d개%n", prize, matchingResult.getOccurrences(prize));
        }
    }

    private void printLottoEarningsRate(LottoMatchingResult matchingResult) {
        System.out.println();
        System.out.printf("총 수익률은 %2.0f%%입니다.%n", matchingResult.getEarningsRate());
    }
}
