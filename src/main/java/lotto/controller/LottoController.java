package lotto.controller;

import lotto.service.LottoService;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class LottoController {

    LottoService lottoService;

    public LottoController() {
        staticFiles.location("/templates");
        lottoService = new LottoService();
        port(8080);

        Spark.get("/index", (req, res) -> {
            return render(null, "index.html");
        });

        Spark.post("/buyLotto", (req, res) -> {
            return render(lottoService.buyLotto(req), "show.html");
        });

        Spark.post("/matchLotto", (req, res) -> {
            return render(lottoService.matchLotto(req), "result.html");
        });
    }

    private String render(Map<Object, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
