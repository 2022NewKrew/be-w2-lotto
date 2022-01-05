package view;

import domain.LottoParameter;
import domain.OneLotto;
import dto.PurchasedLottoDTO;
import dto.WinnigStatisticDTO;

import java.util.List;

public class PrintOutput {
    private List<OneLotto> totalLotto;
    private int lottoCount;

    private List<Integer> countOfTotalWinnings;

    public void printPurchasedLotto(PurchasedLottoDTO purchasedLottoDTO) {
        totalLotto = purchasedLottoDTO.getTotalLotto();
        lottoCount = purchasedLottoDTO.getLottoCount();

        printLottoCount();
        printTotalLotto();
    }

    private void printLottoCount() {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    private void printTotalLotto() {
        for(int i=0; i<lottoCount; i++) {
            System.out.println(totalLotto.get(i).getLottoList().toString());
        }
        System.out.println();
    }

    public void printWinnigStatistic(WinnigStatisticDTO winnigStatisticDTO) {
        countOfTotalWinnings = winnigStatisticDTO.getCountOfTotalWinnings();
        printCountOfTotalWinnings();
    }

    private void printCountOfTotalWinnings() {
        long revenue = 0L;
        for(int i=3; i<=LottoParameter.numberOfLottoPicks; i++) {
            System.out.printf("%d개 일치 (%d) - %d개\n", i, LottoParameter.rankToPrice.get(i), countOfTotalWinnings.get(i));
            revenue += LottoParameter.rankToPrice.get(i) * countOfTotalWinnings.get(i);
        }
        System.out.printf("총 수익률은 %f%%입니다.\n", calculateRevenue(revenue));
    }

    private double calculateRevenue(long revenue) {
        double principal = lottoCount * LottoParameter.priceForOneLotto;
        return 100 * ((double)revenue - principal) / principal;

    }
}
