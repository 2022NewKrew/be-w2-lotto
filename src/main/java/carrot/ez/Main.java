package carrot.ez;

import carrot.ez.controller.LottoController;
import carrot.ez.dto.response.LottosDto;
import carrot.ez.dto.response.LottosResultDto;
import carrot.ez.service.LottoService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    private static final LottoController lottoController = new LottoController(new LottoService());
    public static void main(String[] args) {
        staticFiles.location("/static");
        port(8080);

        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");
            LottosDto lottos = lottoController.buyLottos(inputMoney, manualNumber);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosInfo", lottos);

            return render(model, "show.html");
        });

        post("/matchLotto/:id", (req, res) -> {
            String id = req.params(":id");
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");
            LottosResultDto lottosResultDto = lottoController.matchLottos(id, winningNumber, bonusNumber);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosResult", lottosResultDto);

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
