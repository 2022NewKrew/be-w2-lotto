package lotto.view;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.domain.Prize;

import java.util.Map;
import java.util.Set;

import static lotto.domain.LottoShop.PRICE;

public class LottoPrinter {

    public void printLottoResult(LottoShop lottoShop, Gambler gambler, int bonusBall) {
        Set<Integer> winnerNumber = lottoShop.getWinnerNumber();
        Map<Prize, Long> matchingResult = gambler.getMatchingResult(winnerNumber, bonusBall);

        printLottoMatchingResult(matchingResult);
        printLottoEarningsRate(gambler, matchingResult);
    }

    private void printLottoMatchingResult(Map<Prize, Long> matchingResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for (Prize prize : Prize.values()) {
            Long occurrence = matchingResult.getOrDefault(prize, 0L);
            System.out.printf("%s - %d개%n", prize, occurrence);
        }
    }

    private void printLottoEarningsRate(Gambler gambler, Map<Prize, Long> matchingResult) {
        long prizeMoneySum = 0L;
        for (var entry : matchingResult.entrySet()) {
            Prize prize = entry.getKey();
            Long occurrence = entry.getValue();
            prizeMoneySum += prize.getMoney() * occurrence;
        }

        int purchaseCosts = PRICE * gambler.getTickets().size();
        System.out.println();
        System.out.printf("총 수익률은 %2.0f%%입니다.%n", ((float)(prizeMoneySum - purchaseCosts) / purchaseCosts) * 100);
    }
}
