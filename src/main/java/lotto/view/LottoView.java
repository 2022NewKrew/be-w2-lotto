package lotto.view;

import lotto.configure.LottoConfigure;
import lotto.vo.LottoVO;
import lotto.result.LottoResult;

import java.io.InputStream;
import java.util.*;

public class LottoView {

    private LottoView() {}

    public static int inputPurchaseAmount(InputStream inputStream) {
        return LottoInputView.inputPurchaseAmount(inputStream);
    }

    public static List<List<Integer>> inputPurchaseByUserNumbers(InputStream inputStream) {
        return LottoInputView.inputPurchaseByUserNumbers(inputStream);
    }

    public static void outputPurchaseResult(List<LottoVO> lottos) {
        LottoOutputView.outputPurchaseResult(lottos);
    }

    public static List<Integer> inputLastWeekLottoNumbers(InputStream inputStream) {
        return LottoInputView.inputLastWeekLottoNumbers(inputStream);
    }

    public static int inputBonusBall(InputStream inputStream) {
        return LottoInputView.inputBonusBall(inputStream);
    }

    public static void outputLottoResult(List<LottoResult> lottoResults) {
        LottoOutputView.outputLottoResult(lottoResults);
    }

}
