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

    // 기존 purchase 오버로딩
    public String purchase(Request req, Response res){
        final int purchaseAmount = Integer.parseInt(req.queryParams("inputMoney"));
        final List<List<Integer>> manualNumber = convertManualNumberInput(req.queryParams("manualNumber"));

        // lottoConfig 를 상속한 객체: 수동으로 입력받은 번호를 담은 객체(ManualLottoInnerConfig)를 멤버 변수로 가지도록 함
        LottoConfigWithManual lottoConfigWithManual = new LottoConfigWithManual(purchaseAmount, new ManualLottoInnerConfig(manualNumber.size(), manualNumber));
        LottoSheetDto lottoSheetDto = super.purchase(lottoConfigWithManual);

        // 쿠키 설정
        res.cookie(COOKIE_USER_ID_KEY, lottoSheetDto.getId().toString());

        // Model에 DTO 전달
        Map<String, Object> model = new HashMap<>();
        model.put("lottoSheetDto", lottoSheetDto);
        return render(model, "show.html");
    }

    // 기존 checkLotteryResult 오버로딩
    public String checkLotteryResult(Request req, Response res){
        List<Integer> winningNumber = strToIntList(req.queryParams("winningNumber"));
        int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
        // 당첨번호 객체 생성
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        // 당첨 결과를 받아오기
        LottoResultDto lottoResultDto = super.checkLotteryResult(winningLotto, Long.parseLong(req.cookie(COOKIE_USER_ID_KEY)));
        // 당첨 결과를 모델에 맞게 변환
        LottoResultViewDto lottoResultViewDto = new LottoResultViewDto(lottoResultDto.toStringList(), lottoResultDto.rateOfReturn());

        // Model DTO 전달
        Map<String, Object> model = new HashMap<>();
        model.put("lottoResultViewDto", lottoResultViewDto);
        return render(model, "result.html");
    }

    // req 의 String 로또 번호 리스트를 Integer로 변환
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
