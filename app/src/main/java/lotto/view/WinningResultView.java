package lotto.view;

import lotto.domain.lotto.result.WinningRanking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class WinningResultView {

    private final Map<WinningRanking, Long> result;
    private final int earningRate;

    private WinningResultView(Map<WinningRanking, Long> result, int earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }

    public static WinningResultView createWinningResultView(Map<WinningRanking, Long> result, int earningRate) {
        return new WinningResultView(result, earningRate);
    }

    public void printView(BufferedWriter output) throws IOException {

        output.write("\n");
        output.write("당첨 통계" + "\n");
        output.write("-------------" + "\n");
        output.write(3 + "개 일치 (5000원)- " + getToMap(WinningRanking.FIFTH) + "개" + "\n");
        output.write(4 + "개 일치 (50000원)- " + getToMap(WinningRanking.FOURTH) + "개" + "\n");
        output.write(5 + "개 일치 (1500000원)- " + getToMap(WinningRanking.THIRD) + "개" + "\n");
        output.write(5 + "개 일치, 보너스 볼 일치(30000000원)- " + getToMap(WinningRanking.SECOND) + "개" + "\n");
        output.write(6 + "개 일치 (2000000000원)- " + getToMap(WinningRanking.FIRST) + "개" + "\n");
        output.write("총 수익률은 " + earningRate + "%입니다" + "\n");
        output.flush();
    }

    private int getToMap(WinningRanking key) {
        return result.getOrDefault(key, 0L).intValue();
    }
}
