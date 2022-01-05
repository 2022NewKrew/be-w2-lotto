package lotto.view;

import lotto.domain.Constants;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeType;
import lotto.dto.LottoResultDTO;

import java.util.List;

public class OutputView {

    public void printLottoTickets(List<LottoTicket> lottoTickets, int manualPurchaseCount, int autoPurchaseCount) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualPurchaseCount, autoPurchaseCount);
        lottoTickets.forEach(System.out::println);
    }

    public void printLottoResult(LottoResultDTO lottoResultDTO, int purchaseCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", lottoResultDTO.getFifthPrizeCount());
        System.out.printf("4개 일치 (50000원)- %d개\n", lottoResultDTO.getFourthPrizeCount());
        System.out.printf("5개 일치 (1500000원)- %d개\n", lottoResultDTO.getThirdPrizeCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (30000000원)- %d개\n", lottoResultDTO.getSecondPrizeCount());
        System.out.printf("6개 일치 (2000000000원)- %d개\n", lottoResultDTO.getFirstPrizeCount());
        System.out.printf("총 수익률은 %.2f%%입니다.", calculateProfitRate(lottoResultDTO, purchaseCount));
    }

    private double calculateProfitRate(LottoResultDTO lottoResultDTO, int purchaseCount) {
        int purchaseAmount = purchaseCount * Constants.LOTTO_PRICE;
        return (getSumOfPrize(lottoResultDTO) - purchaseAmount) / (double)(purchaseAmount) * 100;
    }

    private int getSumOfPrize(LottoResultDTO lottoResultDTO) {
        return lottoResultDTO.getFirstPrizeCount() * PrizeType.FIRST_PRIZE.getMoney() +
                lottoResultDTO.getSecondPrizeCount() * PrizeType.SECOND_PRIZE.getMoney() +
                lottoResultDTO.getThirdPrizeCount() * PrizeType.THIRD_PRIZE.getMoney() +
                lottoResultDTO.getFourthPrizeCount() * PrizeType.FOURTH_PRIZE.getMoney() +
                lottoResultDTO.getFifthPrizeCount() * PrizeType.FIFTH_PRIZE.getMoney();
    }
}
