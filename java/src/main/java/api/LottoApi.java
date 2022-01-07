package api;

import domain.LottoController;
import domain.LottoTicket;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

public class LottoApi {
    private final LottoController lottoController;
    public Route buyLotto;
    public Route matchLotto;

    public LottoApi() {
        lottoController = new LottoController();
        createAndShowLottoTicket();
        matchAndShowResult();
    }

    public void createAndShowLottoTicket() {
        buyLotto = new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> model = new HashMap<>();

                var tickets = lottoController.buyLotto(request);
                request.session().attribute("tickets", tickets);
                model.put("lottosSize", tickets.size());
                model.put("lottos", tickets);

                return render(model, "show.html");
            }
        };
    }

    public void matchAndShowResult() {
        matchLotto = new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> model = new HashMap<>();
                Map<String, Object> subModel = new HashMap<>();

                List<LottoTicket> tickets = request.session().attribute("tickets");
                var rankCount = lottoController.classifyTicketRank(tickets, request);

                subModel.put("message", lottoController.showAllRank(rankCount));
                subModel.put("totalRateOfReturn", lottoController.calculateEarnRatio(rankCount));
                model.put("lottosResult", subModel);

                return render(model, "result.html");
            }
        };
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
