package lotto;

import lotto.controller.LottoController;
import static spark.Spark.*;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String args[]) {
        port(8080);

        get("/", (req, res) -> {
            return LottoController.serveIndexPage(req, res);
        });

        post("/buyLotto", (req, res) -> {
            return LottoController.buyLotto(req, res);
        });

        post("/matchLotto", (req, res) -> {
            return LottoController.matchLotto(req, res);
        });
    }
}
