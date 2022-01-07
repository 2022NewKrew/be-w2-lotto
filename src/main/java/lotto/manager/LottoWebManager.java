package lotto.manager;

import lotto.domain.model.LottoResult;
import lotto.service.LottoService;
import lotto.util.StringConverter;
import lotto.view.LottoView;
import lotto.view.LottoWebView;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoWebManager implements LottoManager {
    private static final LottoWebManager INSTANCE = new LottoWebManager();
    private final LottoService service;
    private final LottoView view;

    private LottoWebManager() {
        service = new LottoService();
        view = new LottoWebView();
    }

    public static LottoWebManager getInstance() {
        return INSTANCE;
    }

    private String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public void run() {
        port(8080);

        get("/", this::index);
        post("/buyLotto", this::buyLotto);
        post("/matchLotto", this::matchLotto);
    }

    private String index(Request req, Response res) {
        Map model = new HashMap<>();
        return render(model, "/index.html");
    }

    private String buyLotto(Request req, Response res) {
        try {
            long money = StringConverter.convertToLong(req.queryParams("inputMoney"));
            List<List<Long>> manualNumbers = StringConverter.multiLineStringToList(req.queryParams("manualNumber"))
                    .stream()
                    .map(StringConverter::parseCommaSeparatedInt)
                    .collect(Collectors.toList());
            service.initializeMoney(money);
            service.initializeManualAmount(manualNumbers.size());
            manualNumbers.forEach(lottoNumber -> {
                service.purchaseManualLotto(lottoNumber);
            });
            service.purchaseAllAutomaticLotto();

            Map model = new HashMap<>();
            model.put("lottosSize", service.getLottoList().size());
            model.put("lottos", service.getLottoList());
            return render(model, "/show.html");
        } catch (NumberFormatException e) {
            return "Hello Bug";
        }
    }

    private String matchLotto(Request req, Response res) {
        try {
            List<Long> numbers = StringConverter.parseCommaSeparatedInt(req.queryParams("winningNumber"));
            long bonusNumber = StringConverter.convertToLong(req.queryParams("bonusNumber"));
            service.createWinningLotto(numbers, bonusNumber);
            service.checkAllLotto();

            Map model = new HashMap<>();
            model.put("lottosResult", service.getLottoResult());
            model.put("message", service.getLottoResult());
            model.put("totalRateOfReturn", service.getEarningsPercent());
            return render(model, "/result.html");
        } catch (NumberFormatException e) {
            return "Hello Bug";
        }
    }

}
