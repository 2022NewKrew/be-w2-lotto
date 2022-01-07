package view;

import dto.LottoRankDto;
import dto.LottoResultDto;
import dto.LottoResultRevenuePercentDto;
import dto.LottosDto;

import java.util.List;

public class UserOutput {

    public static void printLotto(LottosDto lottosDto) {
        for (List<Integer> numbers : lottosDto.getLottos()) {
            System.out.println(numbers.toString());
        }
    }

    public static void printRevenueRate(LottoResultRevenuePercentDto revenuePercentDto) {
        System.out.println("총 수익률은 " + revenuePercentDto.getRevenuePercent() + "% 입니다.");
    }

    public static void printHistory(List<LottoRankDto> lottoRanks, LottoResultDto result) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (LottoRankDto lottoRankDto : lottoRanks) {
            printResultByLottoRank(lottoRankDto, result);
        }
    }

    public static void printBuyMessage(int numberOfManualLotto, int numberOfAutoLotto) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", numberOfManualLotto, numberOfAutoLotto);
    }

    private static void printResultByLottoRank(LottoRankDto lottoRankDto, LottoResultDto lottoResultDto) {
        System.out.println(getResultFormat(lottoRankDto, lottoResultDto.get(lottoRankDto.getRank()), lottoRankDto.getNeedBonusNumber()));
    }

    private static String getResultFormat(LottoRankDto lottoRankDto, int numberOfMatchTicket, boolean needBonusNumber) {
        if (needBonusNumber) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d) - %d개", lottoRankDto.getMatchNumber(), lottoRankDto.getReward(), numberOfMatchTicket);
        }
        return String.format("%d개 일치 (%d) - %d개", lottoRankDto.getMatchNumber(), lottoRankDto.getReward(), numberOfMatchTicket);
    }
}
