package lotto.step5;

import lotto.step1.controller.LottoController;
import lotto.step4.config.WebConfig;
import lotto.step4.controller.LottoGameWebController;
import lotto.step5.controller.LottoGameWebUsingDBController;

import static spark.Spark.post;

public class LottoGameWebUsingDBApplication {
    private final LottoController lottoController;

    public LottoGameWebUsingDBApplication() {
        lottoController = new LottoGameWebUsingDBController();
    }

    public void run() {
        WebConfig.initPort();
        WebConfig.metaData();

        final LottoGameWebUsingDBController lottoController = (LottoGameWebUsingDBController) this.lottoController;

        post("/buyLotto", lottoController::purchase);
        post("/matchLotto", lottoController::confirmTheWin);
    }
}
