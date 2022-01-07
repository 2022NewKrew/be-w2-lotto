package com.kakao.lotto.controller;

import com.kakao.lotto.model.LottoResultCheck;
import com.kakao.lotto.model.SystemLotto;
import com.kakao.lotto.model.UserLotto;
import com.kakao.lotto.view.ChangeVaildInput;
import com.kakao.lotto.model.PreLottoResultInput;
import com.kakao.lotto.view.ResultPrinter;
import com.kakao.lotto.model.UserLottoInput;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.post;

/**
 * author    : brody.moon
 * version   : 1.0
 * 컨트롤러 클래스입니다.
 * Model 과 View 를 이어주는 역활을 합니다.
 */
public class Controller {
    /**
     * Model 의 사용자의 로또와 당첨 로또 클래스를 가지고 있습니다ㅏ.
     * View 로 보여줄 프린트 클래스도 가지고 있습니다.
     */
    private final UserLotto userLotto;
    private final SystemLotto systemLotto;
    private final ResultPrinter resultPrinter;
    private final boolean isAcceptWebUI;

    public Controller() {
        userLotto = new UserLotto(new UserLottoInput.Builder()
                .setNumberOfAllNumber()
                .setNumberOfCustomNumber()
                .setCustomLottos().build());

        // 번호 자동 생성
        //systemLotto = new SystemLotto();

        // 유저 입력 생성
        systemLotto = new SystemLotto(new PreLottoResultInput.Builder()
                .setPreLottoNumber()
                .setBonusNumber().build());

        ChangeVaildInput.close();

        resultPrinter = new ResultPrinter(userLotto, systemLotto);

        isAcceptWebUI = false;
    }

    public Controller(boolean isAcceptWebUI){
        if(!isAcceptWebUI)
            throw new IllegalArgumentException("true를 입력하거나 default 생성자를 사용하세요");

        userLotto = null;
        systemLotto = null;
        resultPrinter = null;
        this.isAcceptWebUI = isAcceptWebUI;
    }

    /**
     * Model 과 View 사이의 프로그램 진행 과정을 모아준 메서드입니다.
     */
    public void start() {
        if(isAcceptWebUI)
            throw new IllegalAccessError("Web UI 처리로는 부적절한 접근입니다");

        resultPrinter.printBuyLottoNumbers();

        System.out.println();

        resultPrinter.printWinningLottoNumber();

        LottoResultCheck lottoResultCheck = new LottoResultCheck(userLotto, systemLotto);

        resultPrinter.printAllLottoResult(lottoResultCheck.lottoResult());
    }

    public void run(){
        if(!isAcceptWebUI)
            throw new IllegalAccessError("UserInput 처리로는 부적절한 접근입니다");

        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            UserLotto userLotto = new UserLotto(new UserLottoInput.Builder()
                    .setNumberOfAllNumber(inputMoney.trim())
                    .setNumberOfCustomNumber(manualNumber)
                    .setCustomLottos(manualNumber)
                    .build()
            );

            model.put("lottosSize", userLotto.getLottoNumbers().size());
            model.put("lottos", userLotto.printLottos());

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            SystemLotto systemLotto = new SystemLotto(new PreLottoResultInput.Builder()
                    .setPreLottoNumber(winningNumber)
                    .setBonusNumber(bonusNumber)
                    .build()
            );

            LottoResultCheck lottoResultCheck = new LottoResultCheck(userLotto, systemLotto);
            ResultPrinter resultPrinter = new ResultPrinter(userLotto, systemLotto);

            model.put("result", resultPrinter.createResultHashMap(lottoResultCheck.lottoResult()));
            model.put("totalRateOfReturn", resultPrinter.createProfitRate(lottoResultCheck.lottoResult()));

            return render(model, "/result.html");
        });
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
