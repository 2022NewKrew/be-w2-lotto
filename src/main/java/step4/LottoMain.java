package step4;

import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;
import step4.controller.LottoGameController;
import step4.controller.ConsoleController;
import step4.controller.ServerController;

import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

public class LottoMain {
    private static final TemplateEngine templateEngine = new HandlebarsTemplateEngine();
    private static LottoGameController lottoGame = new ServerController();

    public static void main(String[] args) {
        try{
            lottoGame.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
