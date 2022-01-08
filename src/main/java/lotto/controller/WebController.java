package lotto.controller;

import static lotto.controller.LottoSimulator.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.PurchaseInfo;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputScannerOnWeb;
import lotto.view.LottoOutputPrinterOnWeb;
import org.jetbrains.annotations.NotNull;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebController {

    private final LottoSimulator lottoSimulator;
    private final LottoInputScannerOnWeb lottoInputScannerOnWeb;
    private final LottoOutputPrinterOnWeb lottoOutputPrinterOnWeb;
    private long purchaseAmount;
    private PurchasedLottos purchasedLottos;

    public WebController(@NotNull LottoSimulator lottoSimulator) {
        this.lottoSimulator = lottoSimulator;
        this.lottoInputScannerOnWeb = lottoSimulator.getLottoInputScanner();
        this.lottoOutputPrinterOnWeb = lottoSimulator.getLottoOutputPrinter();
        init();
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public String purchaseLotto(@NotNull Request req, Response ignoredRes) {
        Map<String, Object> model = new HashMap<>();
        lottoInputScannerOnWeb.setPurchaseAmount(req.queryParams("inputMoney"));
        lottoInputScannerOnWeb.setManualLottoNumberStringList(req.queryParams("manualNumber"));

        setPurchaseAmount(lottoInputScannerOnWeb.getPurchaseAmount());
        long numOfManualLottos = lottoInputScannerOnWeb.getNumOfManualLottos();
        List<String> manualLottoNumberStringList = lottoInputScannerOnWeb.getManualLottoNumberStringList(
            numOfManualLottos);
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, numOfManualLottos,
            manualLottoNumberStringList);
        setPurchasedLottos(lottoSimulator.purchaseLotto(purchaseInfo));
        model.put("lottosSize", purchaseAmount / LOTTO_PRICE);
        model.put("lottos", purchasedLottos);
        return render(model, "show.html");
    }

    private void setPurchaseAmount(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    private void setPurchasedLottos(PurchasedLottos purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public String displayResult(@NotNull Request req, Response ignoredRes) {
        Map<String, Object> model = new HashMap<>();
        lottoInputScannerOnWeb.setWinningLottoNumberList(req.queryParams("winningNumber"));
        lottoInputScannerOnWeb.setBonusNumber(req.queryParams("bonusNumber"));

        WinningLotto winningLotto = lottoSimulator.getWinningInfo();
        lottoSimulator.printWinningStat(purchaseAmount, purchasedLottos, winningLotto);

        List<String> message = lottoOutputPrinterOnWeb.getMessage();
        double yield = lottoOutputPrinterOnWeb.getYield();
        LottosResult lottosResult = new LottosResult(message, yield);
        model.put("lottosResult", lottosResult);
        System.out.println(message);
        System.out.println(yield);

        init();

        return render(model, "result.html");
    }

    public void init() {
        lottoInputScannerOnWeb.init();
        lottoOutputPrinterOnWeb.init();
        purchaseAmount = 0;
        purchasedLottos = null;
    }

    static class LottosResult {

        private final List<String> message;
        private final double totalRateOfReturn;

        public LottosResult(List<String> message, double totalRateOfReturn) {
            this.message = message;
            this.totalRateOfReturn = totalRateOfReturn;
        }

        public List<String> getMessage() {
            return message;
        }

        public double getTotalRateOfReturn() {
            return totalRateOfReturn;
        }
    }
}
