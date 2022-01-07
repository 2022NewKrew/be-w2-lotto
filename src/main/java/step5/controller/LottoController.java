package step5.controller;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import step5.model.domain.Lottos;
import step5.model.domain.Matches;
import step5.model.service.LottosService;
import step5.model.service.LottosServiceImpl;
import step5.model.service.MatchesService;
import step5.model.service.MatchesServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoController {
    private static final HandlebarsTemplateEngine TEMPLATE_ENGINE = new HandlebarsTemplateEngine();
    private static final LottoController INSTANCE = new LottoController();

    private final LottosService lottosService = LottosServiceImpl.getInstance();
    private final MatchesService matchesService = MatchesServiceImpl.getInstance();

    private LottoController() {}

    public static LottoController getInstance() {
        return INSTANCE;
    }

    public void startService() {
        port(8080);
        staticFileLocation("/static");
        exceptionHandle();
        index();
        buyLottos();
        showLottos();
        matchLottos();
        matchedLottos();
    }

    private void exceptionHandle() {
        exception(RuntimeException.class, (exception, request, response) -> {
            response.status(400);
            Map<String, Object> model = new HashMap<>();

            model.put("exceptionMsg", exception.getMessage());
            response.body(render(model, "error.html"));
        });
    }

    private void index() {
        get("/", (request, response) -> "index.html");
    }

    private void buyLottos() {
        post("/buyLottos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Lottos lottos = lottosService.selectAllLottosFromRepository();

            Lottos newLottos = lottosService.makeLottos(request.queryParams("moneyForBuy"),
                                            request.queryParams("manualLottos"));

            lottosService.insertLottosToRepository(newLottos);

            lottos.addLottos(newLottos);

            model.put("lottosQuantity", lottos.size());
            model.put("lottos", lottos);
            return render(model, "show.html");
        });
    }

    private void showLottos() {
        get("/show-lottos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Lottos lottos = lottosService.selectAllLottosFromRepository();

            model.put("lottosQuantity", lottos.size());
            model.put("lottos", lottos);
            return render(model, "show.html");
        });
    }

    private void matchLottos() {
        post("/matchLottos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Lottos lottos = lottosService.selectAllLottosFromRepository();

            Matches matches = matchesService.startMatch(lottos, request.queryParams("result"),
                                                request.queryParams("bonusNumber"));

            matchesService.updateMatchesInRepository(matches);

            model.put("matchResults", matches);
            model.put("totalRateOfReturn", matches.calcTotalRateOfReturn(lottos));
            return render(model, "result.html");
        });
    }

    private void matchedLottos() {
        get("/matched-lottos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Lottos lottos = lottosService.selectAllLottosFromRepository();
            Matches matches = matchesService.selectAllMatchesFromRepository();

            model.put("matchResults", matches);
            model.put("totalRateOfReturn", matches.calcTotalRateOfReturn(lottos));
            return render(model, "result.html");
        });
    }

    private String render(Map<String, Object> model, String templatePath) {
        return TEMPLATE_ENGINE.render(new ModelAndView(model, templatePath));
    }
}
