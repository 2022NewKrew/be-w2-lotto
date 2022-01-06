package controller;

import dto.LastWeekWinningNumber;
import dto.LottoResultDTO;
import dto.PurchasingSheet;
import service.AutoLottoService;
import service.LottoService;
import service.LottoValueObject;
import service.lotto.LottoBundle;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.util.TypeConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebController {
    private final LottoService lottoService = new AutoLottoService();

    public String purchaseLotto(Request req, Response res) {
        final int money = TypeConverter.strToInteger(req.queryParams("inputMoney"));
        final List<List<Integer>> manualLottoNumbers = TypeConverter.strWithLineBreakerToListOfListInteger(req.queryParams("manualNumber"));
        final int manualLottoQuantity = manualLottoNumbers.size();
        final int autoLottoQuantity = money / LottoValueObject.LOTTO_PRICE - manualLottoQuantity;
        Long lottoId = lottoService.purchaseLotto(new PurchasingSheet(autoLottoQuantity, manualLottoQuantity, manualLottoNumbers));
        LottoBundle purchasedLottoBundle = lottoService.getPurchasedLottoBundle(lottoId);
        Map<String, Object> model = buildShowModel(lottoId, purchasedLottoBundle);
        return render(model, "show.html");
    }

    private Map<String, Object> buildShowModel(Long lottoId, LottoBundle purchasedLottoBundle) {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosSize", purchasedLottoBundle.getLottoBundle().size());
        model.put("lottos", purchasedLottoBundle.getLottoBundle());
        model.put("lottoId", lottoId);
        return model;
    }

    public String matchLotto(Request req, Response res) {
        final List<Integer> winningNumber = TypeConverter.strWithCommaToListInteger(req.queryParams("winningNumber"));
        final int bonusNumber = TypeConverter.strToInteger(req.queryParams("bonusNumber"));
        Long lottoId = TypeConverter.strToLong(req.queryParams("lottoId"));
        LottoResultDTO lottoResultDTO = lottoService.getLottoResult(new LastWeekWinningNumber(winningNumber, bonusNumber), lottoId);
        HashMap<String, Object> model = buildMatchModel(lottoResultDTO);
        return render(model, "result.html");
    }

    private HashMap<String, Object> buildMatchModel(LottoResultDTO lottoResultDTO) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("message", lottoResultDTO.buildMessages());
        model.put("totalRateOfReturn", lottoResultDTO.getYield());
        return model;
    }

    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
