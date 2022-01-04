package view.screen;

import view.dto.WinningResultResponse;
import view.model.WinningStatisticalData;

import java.util.Collections;
import java.util.List;

public class LottoResultScreen {

    private static final String MESSAGE_PRINT_STATISTICS_ROW = "%d개 일치 (%d원) - %d개";
    private static final String MESSAGE_PRINT_STATISTICS_ROW_BONUS = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String PROFIT_RATIO_PRINT_FORMAT = "총 수익률은 %d%%입니다.";

    public void printLottoResults(WinningResultResponse lottoGameResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<WinningStatisticalData> statisticalDataList = lottoGameResponse.getWinningStatisticalDataList();
        Collections.sort(statisticalDataList);
        statisticalDataList.forEach(this::printLottoResultRow);
        System.out.println(String.format(PROFIT_RATIO_PRINT_FORMAT, (int)(lottoGameResponse.getProfitRatio() * 100)));
    }

    private void printLottoResultRow(WinningStatisticalData winningStat) {
        String printMessage = MESSAGE_PRINT_STATISTICS_ROW;
        if(winningStat.getWinningCount() == 5 && winningStat.getMatchBonus()) {
            printMessage = MESSAGE_PRINT_STATISTICS_ROW_BONUS;
        }
        System.out.println(String.format(printMessage, winningStat.getWinningCount(), winningStat.getWinnings(), winningStat.getCount()));
    }
}
