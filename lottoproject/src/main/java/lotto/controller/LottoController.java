package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Round;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;

public class LottoController {
    public static String serveIndexPage(Request req, Response res){
        Map model = new HashMap<>();
        return render(model, "/index.html");
    }

    public static String buyLotto(Request req, Response res){
        Map model = new HashMap<>();
        LottoGenerator lottogenerator = new LottoGenerator(req.queryParams("inputMoney"), req.queryParams("manualNumber"));
        Lottos lottos = lottogenerator.generate();
        model.put("lottosSize", lottos.findSize());
        model.put("lottos", lottos.getLottos());
        req.session().attribute("lottos", lottos);
        return render(model, "/show.html");
    }

    public static String matchLotto(Request req, Response res){
        Map model = new HashMap<>();
        Round round = new Round(req.session().attribute("lottos"), req.queryParams("winningNumbers"), req.queryParams("bonusNumber"));
        model.put("result", round.getResult());
        return render(model, "/result.html");
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
