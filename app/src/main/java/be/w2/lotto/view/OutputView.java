package be.w2.lotto.view;

import be.w2.lotto.dto.OutputWinningResultsDto;

import java.util.List;

public class OutputView {
    public static void outputLottoAmounts(int lottoTicketAmount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTicketAmount);
    }

    public static void outputLottoTickets(List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void outputWinningResult(OutputWinningResultsDto outputWinningResultsDto) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        outputWinningResultsDto.winningResults.forEach(winningResult ->
                {
                    System.out.print(winningResult.matchedNumber + "개 일치");
                    if (winningResult.isBonusRound) System.out.print(", 보너스 볼 일치");
                    System.out.println("(" + winningResult.reward + "원);- " + winningResult.count + "개");
                }
        );
        System.out.println("총 수익률은 " + outputWinningResultsDto.profitRate +"%입니다.");
    }
}
