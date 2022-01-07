package com.kakao;

import com.kakao.helper.TextHelper;
import com.kakao.lotto.LottoGame;
import com.kakao.model.LottoNumbers;
import com.kakao.model.Lottos;
import com.kakao.model.Money;
import com.kakao.model.lotto.Lotto;
import com.kakao.model.lotto.ManualLotto;
import org.w3c.dom.Text;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    private static final String manualNumberListSplit = "\r\n";
    private static final String manualNumberSplit = ",";

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model,templatePath));
    }

    public static void main(String[] args) {
        staticFiles.location("/static");

        // 수동 로또 구매
        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            List<String> manualNumberStrList = TextHelper.seperateString(manualNumber, manualNumberListSplit);
            List<Lotto> lottoNumbersIntList = new ArrayList<>();
            for(String manualNumberStr : manualNumberStrList) {
                List<String> separatedNumbersStr = TextHelper.seperateString(manualNumberStr, manualNumberSplit);
                List<Integer> separatedNumbers = TextHelper.convertListType(separatedNumbersStr, Integer::parseInt);
                lottoNumbersIntList.add(new ManualLotto(new LottoNumbers(separatedNumbers)));
            }

            Money money = new Money(Integer.parseInt(inputMoney));
            Lottos lottos = new Lottos(money, lottoNumbersIntList);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", lottos.getLottoList().size());
            model.put("lottos", lottos.getLottoList());
            return render(model, "show.html");
        });
//
//        post("/matchLotto", (req, res) -> {
//
//        })
    }
}
