package view;

import domain.model.LottoWinningType;
import view.dto.WinningResultResponse;

import java.util.Map;

public class LottoResultScreen {

    private static final String RESULT_PRINT_FORMAT = "%d개 일치 (%d원) - %d개";

    private static final String PROFIT_RATIO_PRINT_FORMAT = "총 수익률은 %d%%입니다.";

    public void printLottoResults(WinningResultResponse lottoGameResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Integer, Integer> lottoResultCountMap = lottoGameResponse.getLottoResultCountMap();
        for(int count = 3; count < 7; count++) {
            System.out.println(String.format(RESULT_PRINT_FORMAT, count,
                    LottoWinningType.getWinningsWinningCount(count).getWinnings(),
                    lottoResultCountMap.getOrDefault(count, 0)));
        }
        System.out.println(String.format(PROFIT_RATIO_PRINT_FORMAT, (int)(lottoGameResponse.getProfitRatio() * 100)));
    }
}
