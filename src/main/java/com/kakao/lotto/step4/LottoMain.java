package com.kakao.lotto.step4;

import com.kakao.lotto.step4.core.Lotto;
import com.kakao.lotto.step4.core.LottoParser;
import com.kakao.lotto.step4.core.LottoResult;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class LottoMain {

    private int bonusNumber;
    private int lottoCount;
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    private LottoParser lottoParser = new LottoParser();

    private void init() {
        port(8080);
        staticFiles.location("/public");
    }

    public void makeRandomLotto() {
        lottos.addAll(Lotto.makeLottos(lottoCount - lottos.size()));
    }

    public void buyLotto() {
        post("/buyLotto", (req, res) -> {
            try {
                lottoCount = lottoParser.getLottoCount(req.queryParams("inputMoney"));
                Map<String, Object> model = new HashMap<>();
                lottos = lottoParser.getManualLottos(req.queryParams("manualNumber"));
                makeRandomLotto();
                model.put("lottos", lottos);
                return render(model, "show.html");
            } catch(Exception e) {
                return e.toString();
            }
        });
    }

    public void matchLotto() {
        post("/matchLotto", (req, res) -> {
            try{
                winningNumbers = lottoParser.stringToLotto(req.queryParams("winningNumber")).getLotto();
                bonusNumber = lottoParser.getBonusNumber(req.queryParams("bonusNumber"));
                LottoResult lottoResult = new LottoResult(lottos, winningNumbers, bonusNumber);
                Map<String, Object> model = lottoResult.getResults();
                return render(model, "result.html");
            } catch(Exception e) {
                return e.toString();
            }
        });
    }

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();
        lottoMain.init();
        lottoMain.buyLotto();
        lottoMain.matchLotto();
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
