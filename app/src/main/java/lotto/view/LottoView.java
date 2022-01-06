package lotto.view;

import lotto.domain.lotto.number.Lotto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public final class LottoView {

    private final List<Lotto> lotteries;
    private final int manualCount;

    private LottoView(List<Lotto> lotteries, int manualCount) {
        this.lotteries = lotteries;
        this.manualCount = manualCount;
    }

    public static LottoView createLottoView(List<Lotto> lotteries, int manualCount) {
        return new LottoView(lotteries, manualCount);
    }

    public void printView(BufferedWriter output) throws IOException {
        output.write("수동으로 " + manualCount + "장 " + "자동으로 " + (lotteries.size() - manualCount) + "장을 구매했습니다\n");
        for (Lotto lotto : lotteries) {
            output.write(lotto.toString()+"\n");
        }
        output.flush();
    }
}
