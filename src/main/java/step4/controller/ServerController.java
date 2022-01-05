package step4.controller;

import java.util.Map;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.Route;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class ServerController implements LottoGameController {

    private static final TemplateEngine templateEngine = new HandlebarsTemplateEngine();

    @Override
    public void run() {
        port(8080);
        get("/", getIndexPage());
    }


    public Route getIndexPage() {
        return (request, response) -> templateEngine.render(new ModelAndView(Map.of(), "/index.html"));
    }
}
