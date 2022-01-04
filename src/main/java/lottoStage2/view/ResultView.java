package lottoStage2.view;

import lottoStage2.domain.lotto.Lotto;
import lottoStage2.domain.lotto.Lottos;
import lottoStage2.domain.winning.WinningResult;
import lottoStage2.domain.winning.WinningType;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String DASH_LINE = "----------";
    private static final String SHOW_WINNING_RESULT_MESSAGE = "%s (%d원) - %d개%n";
    private static final String WINNING_RESULT_REVENUE_MESSAGE = "총 수익률을 %d 입니다.%n";

    public static void showLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + " 개를 구매했습니다.");
    }

    public static void showAllLottoNumbers(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + prettyLottoNumber(lotto) + "]");
        }
    }

    private static String prettyLottoNumber(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(", "));
    }

    public static void showStatistics(int price, WinningResult winningResult) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(DASH_LINE);

        showWinningResult(winningResult);
        showWinningResultRevenue(price, winningResult);
    }

    private static void showWinningResultRevenue(int price, WinningResult winningResult) {
        System.out.printf(WINNING_RESULT_REVENUE_MESSAGE, (int)((winningResult.totalWinnings() / (float)price) * 100));
    }

    private static void showWinningResult(WinningResult winningResult) {
        Map<WinningType, Integer> winningResultMap = winningResult.getWinningResult();
        for(WinningType type : winningResultMap.keySet()) {
            System.out.printf(SHOW_WINNING_RESULT_MESSAGE,
                    type.getMessage(), type.getWinnings(), winningResultMap.get(type));
        }
    }
}
