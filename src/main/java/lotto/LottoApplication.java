package lotto;

import java.util.List;

public class LottoApplication {
    public static void run(){
        LottoController lottoController = new LottoController();

        List<LottoDto> lottos = lottoController.purchaseLottos(LottoView.inputPurchaseAmount(System.in));

        List<Integer> lastWeekLottoNumbers = LottoView.inputLastWeekLottoNumbers(System.in);

        int bonusBall = LottoView.inputBonusBall(System.in);

        List<LottoResult> lottoResults = LottoResult.createLottoResults(lottos, lastWeekLottoNumbers, bonusBall);

        LottoView.outputLottoResult(lottoResults);
    }
}
