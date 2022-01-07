package controller;

import domain.lotto.*;
import dto.*;
import service.*;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;

public class LottoGameController {

    private final LottoInputService lottoInputService;
    private final LottoGenerateService lottoGenerateService;
    private final LottoCalculateService lottoCalculateService;

    public LottoGameController() {
        this.lottoInputService = new LottoInputService();
        this.lottoGenerateService = new LottoGenerateService();
        this.lottoCalculateService = new LottoCalculateService();
    }

    public String index(Request request, Response response) {
        return render(null, "/index.html");
    }

    public String createLotto(Request request, Response response) {
        String inputMoney = request.queryParams("inputMoney");
        String inputManualRequests = request.queryParams("manualNumber");

        int money = lottoInputService.getIntegerFromString(inputMoney);
        List<LottoOrder> manualLottoOrders = lottoInputService.getManualLottoRequests(inputManualRequests);
        LottoGameInfo lottoGameInfo = new LottoGameInfo(money, manualLottoOrders);
        List<Lotto> lottos = lottoGenerateService.createLottos(lottoGameInfo);

        request.session().attribute("lottos", lottos);
        return render(new LottoCreateResponse(lottos), "/show.html");
    }

    public String getLottoResult(Request request, Response response) {
        String winningNumber = request.queryParams("winningNumber");
        String bonusNumber = request.queryParams("bonusNumber");

        int bonusLottoNumber = lottoInputService.getIntegerFromString(bonusNumber);
        LottoOrder winningLottoOrder = lottoInputService.parseLottoRequest(winningNumber);
        WinningLotto winningLotto = lottoGenerateService.createWinningLotto(winningLottoOrder, bonusLottoNumber);

        List<Lotto> lottos = request.session().attribute("lottos");
        LottoTotalResult totalResult = lottoCalculateService.calculate(lottos, winningLotto);
        return render(totalResult.toResponse(), "/result.html");
    }

    private static String render(Object model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}

