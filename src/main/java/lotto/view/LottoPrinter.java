package lotto.view;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.LottoShop.PRICE;

public class LottoPrinter {

    // TODO: 메서드 분리
    public void PrintLottoMatchingResult(LottoShop lottoShop, Gambler gambler, int bonusBall) {
        Set<Integer> winnerNumber = lottoShop.getWinnerNumber();
        List<LottoTicket> tickets = gambler.getTickets();

        // <Matched, Occurrence>
        Map<Prize, Long> matchingResult = tickets.stream()
                .map(ticket -> ticket.matchWithWinnerNumber(winnerNumber, bonusBall))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");
        long prizeMoneySum = 0L;
        for (var entry: matchingResult.entrySet()) {
            Prize prize = entry.getKey();
            Long occurrence = entry.getValue();

            prizeMoneySum += occurrence * prize.getMoney();
            System.out.printf("%s - %d개%n", prize, occurrence);
        }

        int purchaseCosts = PRICE * tickets.size();
        System.out.println();
        System.out.printf("총 수익률은 %2.0f%%입니다.%n", ((float)(prizeMoneySum - purchaseCosts) / purchaseCosts) * 100);
    }
}
