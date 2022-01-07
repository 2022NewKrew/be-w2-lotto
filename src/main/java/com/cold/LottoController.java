package com.cold;

import static spark.Spark.*;

import com.cold.domain.GameLogic;
import com.cold.models.SingleTicket;
import com.cold.models.WholeTickets;
import com.cold.models.WinningLotto;
import com.cold.models.LottosResult;
import com.cold.view.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//로또 번호 1~45 중 6개의 숫자
public class LottoController {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/static");

        WholeTickets wholeTickets = new WholeTickets();

        post("/buyLotto", (req, res) -> {
            Integer purchaseMoney = Integer.parseInt(req.queryParams("inputMoney"));
            Integer manualLottoCount = InputView.inputManualPurchaseCount(req.queryParams("manualNumber"));
            List<SingleTicket> manualLotto = InputView.inputManualLottoNumbers(req.queryParams("manualNumber"));

            Integer autoLottoCount = GameLogic.calculateAutoLottoCount(purchaseMoney, manualLottoCount);

            wholeTickets.initTickets(autoLottoCount);
            wholeTickets.addManualLotto(manualLotto);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", GameLogic.calculateTotalLottoCount(manualLottoCount, autoLottoCount));
            model.put("lottos", wholeTickets.getTickets());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            List<Integer> lastWinningNums = InputView.inputWinningNumber(req.queryParams("winningNumber"));
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningLotto winningLotto = new WinningLotto(lastWinningNums, bonusNumber);

            wholeTickets.calculateResult(winningLotto);
            wholeTickets.setProfitRate();

            LottosResult lottosResult = new LottosResult(wholeTickets);
            Map<String, Object> model = new HashMap<>();
            model.put("lottosResult", lottosResult);
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
