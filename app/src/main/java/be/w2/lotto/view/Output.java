package be.w2.lotto.view;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.result.Result;

import java.util.List;

public final class Output {

    private Output() {
    }

    /**
     * 출력 사항 <br>
     * - 구매한 로또 개수 <br>
     * - 구매한 로또들 번호
     *
     * @param lottos 구매한 로또들
     */
    public static String getOutputOfLottos(List<Lotto> lottos) {
        return LottoOutput.getOutput(lottos);
    }

    /**
     * 출력 사항 <br>
     * - 당첨 횟수 <br>
     * - 내 수익률
     *
     * @param result     내 당첨 횟수
     * @param investment 투자금
     */
    public static String getOutputOfResult(Result result, int investment) {
        return ResultOutput.getOutput(result, investment);
    }
}
