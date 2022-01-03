package view.output;

import domain.Lotto;
import dto.LottoData;

import static domain.LottoGameInfo.PRIZE_OF_LOTTO;

public class ConsoleOutputInterface implements OutputInterface {
    @Override
    public void printTickets(Lotto lotto) {
        lotto.printTickets();
    }

    @Override
    public void printResults(Lotto lotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(int match = 3; match <= 6; match++) {
            System.out.printf("%d 일치 (%d원)-", match, PRIZE_OF_LOTTO.get(match));
            lotto.printResult(match);
            System.out.print("\n");
        }
    }

    @Override
    public void printRevenueRate(LottoData lottoData) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", ((float) lottoData.getRevenue() / lottoData.getBudget()) * 100);
    }
}
