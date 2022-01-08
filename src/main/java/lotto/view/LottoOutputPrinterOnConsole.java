package lotto.view;

import static lotto.controller.LottoSimulator.SEPARATOR;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningResult;
import org.jetbrains.annotations.NotNull;

public class LottoOutputPrinterOnConsole implements LottoOutputPrinter {

    public void printDescription(String msg) {
        System.out.print(msg);
    }

    public void printPurchaseResult(long numOfManualLottos,
        @NotNull List<Lotto> purchasedLottoList) {
        System.out.println("\n수동으로 " + numOfManualLottos + "장, 자동으로 " + (purchasedLottoList.size()
            - numOfManualLottos) + "개를 구매했습니다.");
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
