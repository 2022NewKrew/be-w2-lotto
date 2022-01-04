package be.w2.lotto.view;

import be.w2.lotto.dto.WinningResultDto;

import java.util.List;

public class OutputView {
    public static void outputLottoAmounts(int lottoTicketAmount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTicketAmount);
    }

    public static void outputLottoTickets(List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void outputWinningResult(WinningResultDto winningResultDto) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        winningResultDto.winningMatchResultDtos.forEach(
                dto -> {
                    System.out.print(dto.matchedNumber + "개 일치");
                    if (dto.isBonusRound) System.out.print(", 보너스 볼 일치");
                    System.out.println("(" + dto.reward + "원);- " + dto.count + "개");
                }
        );
        System.out.println("총 수익률은 " + winningResultDto.profitRate +"%입니다.");
    }
}
