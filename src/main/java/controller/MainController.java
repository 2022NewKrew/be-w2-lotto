package controller;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class MainController {
    public void run() {
        staticFiles.location("/static");
        get("/lottoForm", this::lottoForm);
    }

    private String lottoForm(Request req, Response res) {
        String name = "test1";
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        return render(map, "lotto_form.html");
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
