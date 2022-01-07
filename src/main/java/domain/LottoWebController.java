package domain;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.SparkLottoInputController;
import view.SparkLottoRenderer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Lotto.LOTTO_PRICE;

public class LottoWebController {

    private final SparkLottoInputController inputController;
    private final SparkLottoRenderer renderer;
    private final LottoService lottoService;

    private int purchaseAmount;
    private LottoTickets purchasedLottoTickets;

    public LottoWebController(SparkLottoInputController inputController, SparkLottoRenderer renderer, LottoService lottoService) {
        this.inputController = inputController;
        this.renderer = renderer;
        this.lottoService = lottoService;
    }

    public String purChaseLotto(Request req, Response res) {
        Map model = new HashMap<>();
        inputController.setPurchaseAmount(req.queryParams("inputMoney"));
        inputController.setManualLottoNumbers(req.queryParams("manualNumber"));

        purchaseAmount = lottoService.getPurchaseAmount();
        purchasedLottoTickets = lottoService.purchaseLottoTickets(purchaseAmount / LOTTO_PRICE.getValue());

        model.put("lottosSize", purchaseAmount / LOTTO_PRICE.getValue());
        model.put("lottoTickets", purchasedLottoTickets.getLottoTickets());

        return render(model, "/show.html");
    }

    public String matchLotto(Request req, Response res) {
        Map model = new HashMap<>();
        inputController.setLastWeekWinningNumbers(req.queryParams("winningNumber"));
        inputController.setBonusBallNumber(req.queryParams("bonusNumber"));

        final List<Integer> lastWeekWinning = lottoService.getLastWeekWinningNumbers();
        final int bonusBallNumber = lottoService.getBonusBallNumber();

        lottoService.printWinningStatistics(purchaseAmount, purchasedLottoTickets, lastWeekWinning, bonusBallNumber);

        model.put("message", renderer.getMessage());
        model.put("totalRateOfReturn", renderer.getTotalRateOfReturn());

        inputController.init();
        renderer.init();

        return render(model, "/result.html");
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
