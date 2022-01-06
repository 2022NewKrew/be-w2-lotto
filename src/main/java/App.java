import controller.WebLottoController;
import domain.LottoList;
import spark.ModelAndView;
import spark.Redirect;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        WebLottoController controller = new WebLottoController();
        port(8080);

        get("/", (req, res) -> {
            return render(new HashMap<>(), "index.html");
        });

        post("/buyLotto", ((req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try{
                String inputMoney = req.queryParams("inputMoney");
                String manualNumber = req.queryParams("manualNumber");
                model = controller.buyLotto(inputMoney, manualNumber);

                return render(model, "show.html");
            } catch (Exception e){
                model.put("error", true);
                model.put("errorInfo", e.getMessage());

                return render(model, "index.html");
            }
        }));

        post("/matchLotto", ((req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try{
                String winningNumber = req.queryParams("winningNumber");
                String bonusNumber = req.queryParams("bonusNumber");
                model = controller.matchLotto(winningNumber, bonusNumber);

                return render(model, "result.html");
            } catch (Exception e){
                model.put("error", true);
                model.put("errorInfo", e.getMessage());

                return render(model, "show.html");
            }
        }));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
