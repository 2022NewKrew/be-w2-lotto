package lotto.view;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.LottoShop.PRICE;
import static lotto.domain.LottoShop.PRIZES;

public class LottoPrinter {

    // TODO: 메서드 분리
    public void PrintLottoMatchingResult(LottoShop lottoShop, Gambler gambler) {
        Set<Integer> winnerNumber = lottoShop.getWinnerNumber();
        List<LottoTicket> tickets = gambler.getTickets();

        // <Matched, Occurrence>
        Map<Integer, Long> matchingResult = tickets.stream()
                .map(ticket -> ticket.matchWithWinnerNumber(winnerNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("당첨 통계");
        System.out.println("--------------");
        long prizeSum = 0L;
        for (var entry: matchingResult.entrySet()) {
            Integer matched = entry.getKey();
            Long occurrence = entry.getValue();

            Long prize = PRIZES.get(matched);
            prizeSum += occurrence * prize;

            System.out.printf("%d개 일치 (%d원) - %d개%n", matched, prize, occurrence);
        }

        int purchaseCosts = PRICE * tickets.size();
        System.out.printf("총 수익률은 %2.0f%%입니다.%n", ((float)(prizeSum - purchaseCosts) / purchaseCosts) * 100);
    }
}
