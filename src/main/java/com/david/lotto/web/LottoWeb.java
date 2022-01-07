package com.david.lotto.web;

import com.david.lotto.Lotto;
import com.david.lotto.LottoMachine;
import com.david.lotto.db.H2;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;


public class LottoWeb {

    private LottoMachine lottoMachine = null;
    private final H2 h2 = new H2();
    public void runWebUI() {
        port(8080);
        staticFiles.location("/templates");

        h2.createLottoTable();
        h2.createLottoResultTable();
        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            lottoMachine = new LottoMachine(req.queryParams("inputMoney"), req.queryParams("manualNumber"));
            List<Lotto> lottoList = lottoMachine.getLottoList();
            model.put("lottosSize", lottoList.size());
            model.put("lottos", lottoList);
            h2.insertLotto(lottoList);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Map<String, Object> messageModel = new HashMap<>();
            lottoMachine.calculateResult(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));
            messageModel.put("message", lottoMachine.getLottoCalculate());
            model.put("lottosResult", messageModel);
            model.put("totalRateOfReturn", lottoMachine.getProfitRate());
            h2.insertLottoResult(lottoMachine.getLottoCalculate().getTotalCount());
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
