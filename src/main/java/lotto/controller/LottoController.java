package lotto.controller;

import lotto.view.LottoView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class LottoController {
    private final LottoWebInput lottoWebInput;
    private LottoView lottoView;

    public LottoController() {
        lottoWebInput = new LottoWebInput();
        lottoView = null;
    }

    public void startWeb() {
        port(8080);
        staticFiles.location("/static");

        buyLotto();
        matchLotto();
    }

    private void buyLotto() {
        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            lottoView = new LottoView(lottoWebInput.convertToPurchasedInfoDto(inputMoney, manualNumber));
            model.put("lottosSize", lottoView.getLottoList().size());
            model.put("lottos", lottoView.getLottoList());
            return render(model, "show.html");
        });
    }

    private void matchLotto(){
        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            LottoView.LottoResultWebDto lottoResult = lottoView.getLottoResult(lottoWebInput.convertToWinningLottoDto(winningNumber, bonusNumber));
            model.put("lottosResult", lottoResult.getMessage());
            model.put("totalRateOfReturn", lottoResult.getTotalRateOfReturn());
            return render(model, "result.html");
        });
    }

    private String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
