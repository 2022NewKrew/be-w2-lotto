package step4.view;

import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.Map;

public class WebView implements View<String> {

    private final TemplateEngine templateEngine = new HandlebarsTemplateEngine();

    @Override
    public String getStartPage() {
        return templateEngine.render(new ModelAndView(Map.of(), "/index.html"));
    }

    @Override
    public String showTickets(Map model) {
        return templateEngine.render(new ModelAndView(model, "/show.html"));
    }

    @Override
    public String showResult(Map model) {
        return templateEngine.render(new ModelAndView(model, "/result.html"));
    }
}
