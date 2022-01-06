import controller.LottoGameController;
import dto.LottoResponse;
import dto.LottoResultResponse;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoGame {

    private static final LottoGameController game = new LottoGameController();

    public static void main(String[] args) {
        port(8080);
        mapping();
    }

    private static void mapping() {
        get("/", (req, res) -> render(null ,"/index.html"));

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            List<LottoResponse> lottoResponses = game.createLotto(inputMoney, manualNumber);
            model.put("lottosSize", lottoResponses.size());
            model.put("lottos", lottoResponses);

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            LottoResultResponse lottoResult = game.getLottoResult(winningNumber, bonusNumber);

            return render(lottoResult, "/result.html");
        });
    }

    private static String render(Object model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
