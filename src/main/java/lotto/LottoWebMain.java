package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;
import static spark.Spark.post;

/**
 * Created by melodist
 * Date: 2022-01-06 006
 * Time: 오후 1:16
 */
public class LottoWebMain {
    public static void main(String[] args) {
        port(9000);
        staticFiles.location("/static");

        get("/", (req, res) -> {
            Map model = new HashMap();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Integer inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumberString = req.queryParams("manualNumber");

            Map model = new HashMap();
            LottoBundle lottoBundle = new LottoBundle(inputMoney, manualNumberString);
            req.session().attribute("lottoBundle", lottoBundle);
            model.put("lottosSize", lottoBundle.getLottoCount());
            model.put("lottos", lottoBundle.getLottos());

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumberString = req.queryParams("winningNumber");
            Integer bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            Map model = new HashMap();
            LottoBundle lottoBundle = req.session().attribute("lottoBundle");
            WinningLotto winningLotto = new WinningLotto(winningNumberString, bonusNumber);
            LottoGame lottoGame = new LottoGame();
            LottoResult lottoResult = lottoGame.createResult(lottoBundle, winningLotto);

            model.put("lottosResult", lottoResult);
            return render(model, "/result.html");
        });
    }

    private static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
