package view;

import dto.LottoRecipeDto;
import dto.LottoResultEntryDto;
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

    public static void printHistory(List<LottoResultEntryDto> results, int startIndex) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = startIndex; i < results.size(); i++) {
            printResultByLottoRank(results.get(i));
        }
    }

    public static void printBuyMessage(LottoRecipeDto lottoRecipeDto) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", lottoRecipeDto.getNumberOfManualLotto(), lottoRecipeDto.getNumberOfRandomLotto());
    }

    private static void printResultByLottoRank(LottoResultEntryDto lottoResultEntryDto) {
        System.out.println(getResultFormat(lottoResultEntryDto));
    }

    private static String getResultFormat(LottoResultEntryDto lottoResultEntryDto) {
        if (lottoResultEntryDto.isNeedBonusNumber()) {
            return String
                    .format(
                            "%d개 일치, 보너스 볼 일치 (%d) - %d개",
                            lottoResultEntryDto.getMatchNumber(),
                            lottoResultEntryDto.getReward(),
                            lottoResultEntryDto.getValue()
                    );
        }
        return String
                .format(
                        "%d개 일치 (%d) - %d개",
                        lottoResultEntryDto.getMatchNumber(),
                        lottoResultEntryDto.getReward(),
                        lottoResultEntryDto.getValue()
                );
    }
}
