package step4.controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import step2.controller.LottoControllerImpl;
import step2.domain.WinningLotto;
import step2.domain.service.LottoResultGenerator;
import step2.domain.service.LottoSheetIssuer;
import step2.dto.LottoResultDto;
import step2.dto.LottoSheetDto;
import step2.repository.LottoSheetRepository;
import step3.domain.LottoConfigWithManual;
import step3.domain.ManualLottoInnerConfig;
import step4.dto.LottoResultViewDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWebController extends LottoControllerImpl {

    private static final String COOKIE_USER_ID_KEY = "userId";

    public LottoWebController(LottoSheetIssuer lottoSheetIssuer, LottoSheetRepository lottoSheetRepository, LottoResultGenerator lottoResultGenerator) {
        super(lottoSheetIssuer, lottoSheetRepository, lottoResultGenerator);
    }

    public String purchase(Request req, Response res){
        final int purchaseAmount = Integer.parseInt(req.queryParams("inputMoney"));
        final List<List<Integer>> manualNumber = convertManualNumberInput(req.queryParams("manualNumber"));
        LottoConfigWithManual lottoConfigWithManual = new LottoConfigWithManual(purchaseAmount, new ManualLottoInnerConfig(manualNumber.size(), manualNumber));
        LottoSheetDto lottoSheetDto = super.purchase(lottoConfigWithManual);
        res.cookie(COOKIE_USER_ID_KEY, lottoSheetDto.getId().toString());
        Map<String, Object> model = new HashMap<>();
        model.put("lottoSheetDto", lottoSheetDto);
        return render(model, "show.html");
    }

    public String checkLotteryResult(Request req, Response res){
        List<Integer> winningNumber = strToIntList(req.queryParams("winningNumber"));
        int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoResultDto lottoResultDto = super.checkLotteryResult(winningLotto, Long.parseLong(req.cookie(COOKIE_USER_ID_KEY)));
        LottoResultViewDto lottoResultViewDto = new LottoResultViewDto(lottoResultDto.toStringList(), lottoResultDto.rateOfReturn());
        Map<String, Object> model = new HashMap<>();
        model.put("lottoResultViewDto", lottoResultViewDto);
        return render(model, "result.html");
    }

    private List<List<Integer>> convertManualNumberInput(String input){
        return Arrays.stream(input.split("\r?\n"))
                .map(this::strToIntList)
                .collect(Collectors.toList());
    }

    private List<Integer> strToIntList(String str){
        return Arrays.stream(str.split(","))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
