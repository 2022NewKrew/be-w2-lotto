package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;
import lotto.service.LottoMachine;
import lotto.service.LottoTicketFactory;
import lotto.view.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static spark.Spark.*;

public class LottoApplication {

    private static final InputView inputView = new InputView();
    private static List<LottoTicket> totalLottoTicket;
    private static int purchaseCount;

    public static void run() {

        port(8080);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (request, response) -> {
            String inputMoney = request.queryParams("inputMoney");
            String manualNumber = request.queryParams("manualNumber");

            purchaseCount = inputView.inputPurchaseAmount(inputMoney);
            List<LottoTicket> manualLottoTicket = inputView.inputManualLottoNumbers(manualNumber, purchaseCount);
            List<LottoTicket> autoLottoTicket = LottoMachine.createAutoLottoTickets(purchaseCount - manualLottoTicket.size());
            totalLottoTicket = Stream.concat(manualLottoTicket.stream(), autoLottoTicket.stream()).collect(Collectors.toList());

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", totalLottoTicket);
            model.put("lottosSize", totalLottoTicket.size());

            return render(model, "show.html");
        });

        post("/matchLotto", (request, response) -> {
            LottoTicket winningNumber = LottoTicketFactory.createManualLottoTicket(request.queryParams("winningNumber"));
            int bonusNumber = inputView.inputBonusNumber(winningNumber, Integer.parseInt(request.queryParams("bonusNumber")));
            LottoResult lottoResult = LottoMachine.getLottoResult(totalLottoTicket, winningNumber, bonusNumber);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosResult", lottoResult.toLottoResultDTO(purchaseCount));

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
