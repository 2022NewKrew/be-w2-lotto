import controller.WebLottoController;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    private static WebLottoController controller = new WebLottoController();
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(new HashMap<>(), "index.html"));

        get("/reset", (req, res) -> {
            controller = new WebLottoController();
            res.redirect("/");
            return "";
        });

        post("/buyLotto", ((req, res) -> {
            Map<String, Object> model = controller.buyLotto(req.queryParams("inputMoney"), req.queryParams("manualNumber"));
            return render(model, "show.html");
        }));

        post("/matchLotto", ((req, res) -> {
            Map<String, Object> model = controller.matchLotto(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));
            return render(model, "result.html");
        }));

        exception(RuntimeException.class, ((exception, req, res) ->  {
            Map<String, Object> model = new HashMap<>();
            model.put("error", true);
            model.put("errorInfo", exception.getMessage());
            res.body(render(model, "index.html"));
        }));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
