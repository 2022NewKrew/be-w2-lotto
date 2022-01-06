package step4.controller;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import step4.domain.LottoGame;
import step4.domain.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoController {
    private static final HandlebarsTemplateEngine TEMPLATE_ENGINE = new HandlebarsTemplateEngine();
    private static Lottos lottos;

    public static void startService() {
        port(8080);
        staticFileLocation("/static");
        exceptionHandle();
        index();
        buyLotto();
        matchLotto();
    }

    private static void exceptionHandle() {
        exception(RuntimeException.class, (exception, request, response) -> {
            response.status(400);
            Map<String, Object> model = new HashMap<>();

            model.put("exceptionMsg", exception.getMessage());
            response.body(render(model, "error.html"));
        });
    }

    private static void index() {
        get("/", (request, response) -> "index.html");
    }

    private static void buyLotto() {
        post("/buyLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            lottos = LottoGame.makeLottos(request.queryParams("moneyForBuy"),
                                            request.queryParams("manualLottos"));

            model.put("lottosQuantity", lottos.size());
            model.put("lottos", lottos.getLottos());
            return render(model, "show.html");
        });
    }

    private static void matchLotto() {
        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Matches matches = LottoGame.startMatch(lottos, request.queryParams("result"),
                                                request.queryParams("bonusNumber"));

            model.put("matchResults", matches.toString());
            model.put("totalRateOfReturn", matches.calcTotalRateOfReturn(lottos));
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return TEMPLATE_ENGINE.render(new ModelAndView(model, templatePath));
    }
}
