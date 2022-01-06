package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;
import static lotto.domain.Lotto.NUM_OF_LOTTO_NUMBERS_IN_LOTTO;

public class LottoOutputPrinter {
    public static final String CHECK_LOTTO_NUMBER_MESSAGE = "각 번호는 1~45 사이의 숫자 값을 가져야 합니다.";
    public static final String CHECK_DUPLICATION_MESSAGE = "각 번호는 서로 중복될 수 없습니다.";
    public static final String CHECK_NUM_OF_LOTTO_NUMBERS = "번호는 " + NUM_OF_LOTTO_NUMBERS_IN_LOTTO + "개를 입력해야 합니다.";
    public static final String SPACE = " ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";

    public void printDescription(String msg) {
        System.out.print(msg);
    }

    public void printPurchaseResult(long numOfManualLottos, @NotNull List<Lotto> purchasedLottoList) {
        System.out.println("\n수동으로 " + numOfManualLottos + "장, 자동으로 " + (purchasedLottoList.size() - numOfManualLottos) + "개를 구매했습니다.");
        purchasedLottoList.forEach(this::printLotto);
    }

    private void printLotto(@NotNull Lotto lotto) {
        System.out.println(lotto.getNumberList()
                .stream()
                .sorted()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .collect(Collectors.joining(SEPARATOR + SPACE, PREFIX, SUFFIX)));
    }

    public void printWinningResultPrinter(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n---------");
        for (LottoResult result : LottoResult.values()) {
            StringBuilder resultStr = new StringBuilder();
            System.out.println(resultStr.append(result.getNumOfMatchingNumbers()).append("개 일치")
                    .append(result.equals(LottoResult.SECOND) ? ", 보너스 볼 일치" : " ")
                    .append("(").append(result.getReward()).append("원) - ")
                    .append(winningResult.getCountOf(result)).append("개"));
        }
    }

    public void printWinningYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }
}
