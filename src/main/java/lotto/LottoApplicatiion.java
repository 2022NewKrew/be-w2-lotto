package lotto;

import java.util.List;

public class LottoApplicatiion {

    public static void run(){
        LottoController lottoController = new LottoController();

        List<LottoDto> lottos = lottoController.purchaseLottos(LottoView.inputPurchaseAmount(System.in));

        List<Integer> lastWeekLottoNumbers = LottoView.inputLastWeekLottoNumbers(System.in);

        List<LottoResult> lottoResults = LottoResult.calLottoResults(lottos, lastWeekLottoNumbers);

        LottoView.outputLottoResult(lottoResults);
    }
}
