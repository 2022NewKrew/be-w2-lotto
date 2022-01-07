package com.kakao;

import com.kakao.helper.TextHelper;
import com.kakao.lotto.LottoGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    private static final String manualNumberSplit = "\r?\n";

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model,templatePath));
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
//        lottoGame.play();

        staticFiles.location("/static");

//        // 수동 로또 구매
//        post("/buyLotto", (req, res) -> {
//            String inputMoney = req.queryParams("inputMoney");
//            String manualNumber = req.queryParams("manualNumber");
//
//            List<String> manualNumberList = TextHelper.seperateString(manualNumber, manualNumberSplit);
//            Map<String, Object> model = null;
//            return render(model, "show.html");
//        });
//
//        post("/matchLotto", (req, res) -> {
//
//        })
    }
}
