package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningResult;
import org.jetbrains.annotations.NotNull;

public class LottoOutputPrinterOnWeb implements LottoOutputPrinter {

    private List<String> message;
    private double yield;

    public List<String> getMessage() {
        return message;
    }

    public double getYield() {
        return yield;
    }

    public void printDescription(String msg) {
    }

    public void printPurchaseResult(long numOfManualLottos,
        @NotNull List<Lotto> purchasedLottoList) {
    }

    public void printWinningResultPrinter(WinningResult winningResult) {
        for (LottoResult result : LottoResult.values()) {
            String resultStr = result.getNumOfMatchingNumbers() + "개 일치"
                + (result.equals(LottoResult.SECOND) ? ", 보너스 볼 일치" : " ")
                + "(" + result.getReward() + "원) - "
                + winningResult.getCountOf(result) + "개";
            message.add(resultStr);
        }
    }

    public void printWinningYield(double yield) {
        this.yield = yield;
    }

    public void init() {
        message = new ArrayList<>();
        yield = 0.0;
    }
}
