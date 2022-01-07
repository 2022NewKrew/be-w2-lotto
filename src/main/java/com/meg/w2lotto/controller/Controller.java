package com.meg.w2lotto.controller;

import com.meg.w2lotto.domain.lotto.LottoPack;
import com.meg.w2lotto.domain.result.Statistic;
import com.meg.w2lotto.service.PurchaseService;
import com.meg.w2lotto.service.ResultService;
import com.meg.w2lotto.view.InputView;
import com.meg.w2lotto.view.OutputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    private final PurchaseService purchaseService = PurchaseService.getInstance();
    private final ResultService resultService = ResultService.getInstance();
    private LottoPack lottoPack;

    public void start() {

        run();
        purchaseLotto();
        showResult();
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private void run() {
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });
    }

    private void purchaseLotto() {

        post("/buyLotto", (req, res) -> {
            List<String> manualLotto = List.of(req.queryParams("manualNumber").split("\r?\n"));
            lottoPack = purchaseService.createLottoPack(Integer.parseInt(req.queryParams("inputMoney")));
            purchaseManualLotto(lottoPack, manualLotto);
            purchaseAutolLotto(lottoPack, lottoPack.getCapacity() - manualLotto.size());

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottoPack.getLottos());
            model.put("lottosSize", lottoPack.getCount());
            return render(model, "/show.html");
        });

    }

    private void purchaseManualLotto(LottoPack lottoPack,List<String> manualLotto) {
        for (String strLotto : manualLotto) {
            purchaseService.addManualLotto(lottoPack, StrListToIntList(List.of(strLotto.split(","))));
        }
    }

    private static List<Integer> StrListToIntList(List<String> input) {
        List<Integer> list = new ArrayList<>();
        for (String c : input) {
            list.add(Integer.valueOf(c.strip()));
        }
        return list;
    }

    private void purchaseAutolLotto(LottoPack lottoPack, int autoLottoCount) {
        for (int i=0; i<autoLottoCount; i++) {
            purchaseService.addAutoLotto(lottoPack);
        }
    }

    private void showResult() {
        post("/matchLotto", (req, res) -> {
            List<Integer> winningLottoNumbers = StrListToIntList(List.of(req.queryParams("winningNumber").split(",")));
            int bonusBall = Integer.parseInt(req.queryParams("bonusNumber"));
            Statistic statistic = resultService.createStatistic(winningLottoNumbers, bonusBall, lottoPack);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosResult", statistic);
            return render(model, "/result.html");
        });
    }
}
