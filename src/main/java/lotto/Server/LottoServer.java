package lotto.Server;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoConstants.PRICE_OF_LOTTO;
import static spark.Spark.*;

public class LottoServer {

    public void start() {
        port(8080);
        staticFiles.location("/public/web");

        get("/hello", (req, res) -> "Hello World");
        HashMap<String, Object> model = new HashMap<>();

        post("/buyLotto", (req, res) -> {
            Lottos lottos = new Lottos();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            int numOfLottos = inputMoney / PRICE_OF_LOTTO;

            model.put("inputMoney", inputMoney);
            model.put("numOfLottos", numOfLottos);

            String[] manualNumbers = req.queryParams("manualNumber").split("\r?\n");
            if (manualNumbers[0].equals("")) manualNumbers = new String[]{};
            lottos.add(manualNumbers);
            lottos.generateAutoNumbers(numOfLottos - manualNumbers.length);
            model.put("lottos", lottos);

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            LottoNumbers winningNumber = new LottoNumbers(req.queryParams("winningNumber"));
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
            Lottos lottos = (Lottos) model.get("lottos");
            int inputMoney = (int) model.get("inputMoney");
            LottoResult lr = new LottoResult(inputMoney, lottos, winningNumber, bonusNumber);
            model.put("lottoResult", lr);

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
