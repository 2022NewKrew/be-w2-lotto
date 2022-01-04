package be.w2.lotto.view.output;

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
    public static void outputLottos(List<Lotto> lottos) {
        output(LottoOutput.getOutput(lottos));
    }

    /**
     * 출력 사항 <br>
     * - 당첨 횟수 <br>
     * - 내 수익률
     *
     * @param result     내 당첨 횟수
     * @param investment 투자금
     */
    public static void OutputResult(Result result, int investment) {
        output(ResultOutput.getOutput(result, investment));
    }

    public static void output(String str) {
        System.out.println(str);
    }
}
