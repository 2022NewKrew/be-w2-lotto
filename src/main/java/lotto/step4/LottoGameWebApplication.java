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

        post("/buyLotto", (req, res) -> ((LottoGameWebController) lottoController).purchase(req, res));
        post("/matchLotto", (req, res) -> ((LottoGameWebController) lottoController).confirmTheWin(req, res));
    }
}
