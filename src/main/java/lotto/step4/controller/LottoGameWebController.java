package lotto.step4.controller;

import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.model.LottoGenerator;
import lotto.step1.model.LottoResult;
import lotto.step1.repository.LottoRepository;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step2.controller.LottoAddBonusBallController;
import lotto.step3.model.NonAutoLottoAddBonusBallGenerator;
import lotto.step4.mapper.DTOMapper;
import org.eclipse.jetty.http.HttpHeader;
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

    protected LottoGameWebController(LottoGenerator lottoGenerator, LottoRepository repository) {
        super(lottoGenerator, repository);
    }

    public String purchase(Request req, Response res) {
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = DTOMapper.reqToLottoPurchaseSheetDTO(req);

        final PurchasedLottoDTO purchasedLottoDTO = super.purchase(lottoPurchaseSheetDTO);

        final Map<String, Object> model = new HashMap<>();
        model.put("lottoId", purchasedLottoDTO.getId());
        model.put("lottoNumbersList", purchasedLottoDTO.getLottoNumbersList());

        res.status(200);
        res.header(HttpHeader.CONTENT_TYPE.toString(), "text/html");
        return render(model, "show.html");
    }

    public String confirmTheWin(Request req, Response res) {
        final long lottoId = TypeConverter.strToLong(req.queryParams("lottoId"), Validator.EMPTY_VALIDATOR);
        final ConfirmTheWinDTO confirmTheWinDTO = DTOMapper.reqToConfirmTheWinAddBonusBallDTO(req);
        final LottoResultsDTO lottoResultsDTO = super.confirmTheWin(lottoId, confirmTheWinDTO);

        final Map<String, Object> model = new HashMap<>();
        model.put("results", lottoResultsDTO.getNumOfWinsMapStr());
        model.put("yield", lottoResultsDTO.getYield());

        res.status(200);
        res.header(HttpHeader.CONTENT_TYPE.toString(), "text/html");
        return render(model, "result.html");
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
