package lotto.application;

import lotto.controller.LottoController;
import lotto.request.PurchaseRequest;
import lotto.request.ResultRequest;
import lotto.result.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoWebApplication {
    public static void run() {
        port(8089);

        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        Map<String, Object> model = new HashMap<>();

        get("/", (req, res) -> {
            model.clear();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            List<List<Integer>> manualNumber = Arrays.asList(req.queryParams("manualNumber").split("\r?\n")).stream()
                    .map(s -> Arrays.asList(s.split(",")).stream()
                            .map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
            PurchaseRequest purchaseRequest = new PurchaseRequest(inputMoney, manualNumber);
            List<LottoVO> lottos = lottoController.purchaseLotto(purchaseRequest);
            model.put("lottos", lottos);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            List<Integer> winningNumber = Arrays.stream(req.queryParams("winningNumber").split(",")).map(Integer::parseInt).collect(Collectors.toList());
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
            ResultRequest resultRequest = new ResultRequest((List<LottoVO>)model.get("lottos"), winningNumber, bonusNumber);
            LottoResult lottoResult = lottoController.createLottoResult(resultRequest);
            model.put("lottosResult", lottoResult);
            return render(model, "result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
