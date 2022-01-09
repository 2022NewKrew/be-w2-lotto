package lotto.view;

import lotto.vo.LottoVO;
import lotto.result.LottoRank;

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

    public static void outputPurchaseResult(List<LottoVO> manualLottos, List<LottoVO> autoLottos) {
        LottoOutputView.outputPurchaseResult(manualLottos, autoLottos);
    }

    public static List<Integer> inputLastWeekLottoNumbers(InputStream inputStream) {
        return LottoInputView.inputLastWeekLottoNumbers(inputStream);
    }

    public static int inputBonusBall(InputStream inputStream) {
        return LottoInputView.inputBonusBall(inputStream);
    }

    public static void outputLottoResult(List<LottoRank> lottoRanks) {
        LottoOutputView.outputLottoResult(lottoRanks);
    }

}
