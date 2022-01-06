package lotto.step4;

import lotto.step1.controller.LottoController;
import lotto.step4.config.WebConfig;
import lotto.step4.controller.LottoGameWebController;

import static spark.Spark.post;

public class LottoGameWebApplication {
    private final LottoController lottoController;

    public LottoGameWebApplication() {
        lottoController = new LottoGameWebController();
    }

    public void run() {
        WebConfig.initPort();
        WebConfig.metaData();

        final LottoGameWebController lottoController = (LottoGameWebController) this.lottoController;

        post("/buyLotto", lottoController::purchase);
        post("/matchLotto", lottoController::confirmTheWin);
    }
}
