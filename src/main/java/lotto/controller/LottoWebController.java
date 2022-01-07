package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoInput;
import lotto.domain.LottoPaper;
import lotto.domain.LottoResult;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoWebController {

    public static void startServer(){
        port(8080);
        staticFiles.location("/templates");

        get("/", (req, res)  -> "/index.html");

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = buyLotto(req, res);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) ->{
           Map<String, Object> model = matchLotto(req, res);
           return render(model, "/result.html");
        });
    }

    private static Map<String, Object> buyLotto(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        LottoPaper lp = new LottoPaper();
        LottoInput li = new LottoInput(lp);
        li.prePurchase(req.queryParams("inputMoney"));
        LottoGenerator lg = new LottoGenerator(lp);
        lg.generateLotto(li.getManualNumbers(req.queryParams("manualNumber")));
        model.put("lottosSize", lp.numOfNumbers);
        model.put("lottos", lp.lottoNumbers);
        req.session().attribute("lottoPaper", lp);
        return model;
    }

    private static Map<String, Object> matchLotto(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        LottoResult lr = new LottoResult(
                req.session().attribute("lottoPaper"),
                req.queryParams("winningNumber"),
                req.queryParams("bonusNumber"));
        lr.searchResult();
        lr.updateMessage();
        lr.calculatePrize();
        model.put("lottosResult", lr);
        model.put("message", lr.message);
        model.put("totalRateOfReturn", lr.totalRateOfReturn);
        return model;
    }


    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
