package lotto;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import lotto.controller.LottoSimulator;
import lotto.controller.WebController;
import lotto.view.LottoInputScannerOnWeb;
import lotto.view.LottoOutputPrinterOnWeb;

public class LottoMainOnWeb {

    public static void main(String[] args) {
        staticFiles.location("/public");

        port(8080);

        LottoSimulator lottoSimulator = new LottoSimulator(new LottoInputScannerOnWeb(),
            new LottoOutputPrinterOnWeb());
        WebController webController = new WebController(lottoSimulator);

        post("/buyLotto", webController::purchaseLotto);
        post("/matchLotto", webController::displayResult);
    }
}
