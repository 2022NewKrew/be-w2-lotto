package com.kakao.lotto;

import com.kakao.lotto.model.LottoResultCheck;
import com.kakao.lotto.model.SystemLotto;
import com.kakao.lotto.model.UserLotto;
import com.kakao.lotto.view.PreLottoResultInput;
import com.kakao.lotto.view.ResultPrinter;
import com.kakao.lotto.view.UserLottoInput;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoMain {
    private static UserLotto userLotto;
    private static SystemLotto systemLotto;

    public static void main(String[] args) {
        //콘솔 실행 코드
        //Controller controller = new Controller();
        //controller.start();

        //spark 실행 코드
        port(8080);

        get("/", (req, res) -> {
            Map model = new HashMap<>();

            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map model = new HashMap<>();
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            userLotto = new UserLotto(new UserLottoInput.Builder()
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
            Map model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            System.out.println(winningNumber);
            System.out.println(bonusNumber);
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
