import controller.LottoGameController;
import domain.lotto.Lotto;
import domain.lotto.LottoResponse;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

            List<Lotto> lottos = game.createLotto(inputMoney, manualNumber);
            model.put("lottosSize", lottos.size());
            model.put("lottos", lottos.stream()
                    .map(LottoResponse::new)
                    .collect(Collectors.toList())
            );
            return render(model, "/show.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
