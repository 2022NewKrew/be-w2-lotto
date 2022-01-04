package lotto.step4.controller;

import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step2.controller.LottoAddBonusBallController;
import lotto.step3.model.NonAutoLottoAddBonusBallGenerator;
import lotto.step4.mapper.DTOMapper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class LottoGameWebController extends LottoAddBonusBallController {

    public LottoGameWebController() {
        super(new NonAutoLottoAddBonusBallGenerator());
    }

    public String purchase(Request req, Response res) {
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = DTOMapper.reqToLottoPurchaseSheetDTO(req);

        final PurchasedLottoDTO purchasedLottoDTO = super.purchase(lottoPurchaseSheetDTO);

        final Map<String, Object> model = new HashMap<>();
        model.put("lottoId", purchasedLottoDTO.getId());
        model.put("lottoNumbersList", purchasedLottoDTO.getLottoNumbersList());

        return render(model, "show.html");
    }

    public String confirmTheWin(Request req, Response res) {
        final long lottoId = TypeConverter.strToLong(req.queryParams("lottoId"), Validator.EMPTY_VALIDATOR);
        final ConfirmTheWinDTO confirmTheWinDTO = DTOMapper.reqToConfirmTheWinAddBonusBallDTO(req);

        final LottoResultsDTO lottoResultsDTO = super.confirmTheWin(lottoId, confirmTheWinDTO);

        final Map<String, Object> model = new HashMap<>();
        model.put("results", lottoResultsDTO.getNumOfWinsMap());
        model.put("yield", lottoResultsDTO.getYield());

        return render(model, "result.html");
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
